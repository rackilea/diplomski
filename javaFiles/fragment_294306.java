import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedModel {

    protected static final String[] MAIN_LIST = {"Apples","Oranges","Bananas"};

    public static void main(String[] args) {
        new TabbedModel();
    }

    public TabbedModel() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTabbedPane tabPane = new JTabbedPane();
                tabPane.addTab("A", new ATab());
                tabPane.addTab("B", new ATab());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(tabPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class DefaultCommonModel implements CommonModel {

        private List<ChangeListener> listeners;
        private String value;

        public DefaultCommonModel() {
            listeners = new ArrayList<>(25);
        }

        @Override
        public void addChangeListener(ChangeListener listener) {
            listeners.add(listener);
        }

        @Override
        public void removeChangeListener(ChangeListener listener) {
            listeners.remove(listener);
        }

        @Override
        public void setValue(String aValue) {
            if (aValue == null ? value != null : !aValue.equals(value)) {
                value = aValue;
                fireStateChanged();
            }
        }

        @Override
        public String getValue() {
            return value;
        }

        protected void fireStateChanged() {

            if (!listeners.isEmpty()) {
                ChangeEvent evt = new ChangeEvent(this);
                for (ChangeListener listener : listeners) {
                    listener.stateChanged(evt);
                }
            }

        }

    }

    public interface CommonModel {

        public void addChangeListener(ChangeListener listener);
        public void removeChangeListener(ChangeListener listener);

        public void setValue(String value);
        public String getValue();

    }

    public class CommonPanel extends JPanel {

        private CommonModel model;
        private JComboBox comboBox;

        public CommonPanel(CommonModel model) {
            this.model = model;
            setLayout(new GridBagLayout());
            comboBox = new JComboBox(new DefaultComboBoxModel<>(MAIN_LIST));
            comboBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    String value = (String) e.getItem();
                    CommonPanel.this.model.setValue(value);
                }
            });
            add(comboBox);
        }

    }

    public class ATab extends JPanel {

        private List<JTextField> fields;

        public ATab() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            DefaultCommonModel model = new DefaultCommonModel();
            model.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    CommonModel model = (CommonModel) e.getSource();
                    for (JTextField field : fields) {
                        field.setText(model.getValue());
                    }
                }
            });
            CommonPanel commonPanel = new CommonPanel(model);

            add(commonPanel, gbc);

            fields = new ArrayList<>(25);
            for (int index = 0; index < random(); index++) {
                JTextField field = new JTextField(10);
                add(field, gbc);
                fields.add(field);
            }
        }

        protected int random() {

            return (int)Math.round(Math.random() * 9) + 1;

        }

    }

}