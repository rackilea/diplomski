import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class OrderPane extends JPanel {

    private JPanel chkPanel;
    private int selectedCount = 0;
    private int checkCount = 0;

    private JButton removeButton;

    public OrderPane(int checkCount) {
        setLayout(new BorderLayout());

        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder title = BorderFactory.createTitledBorder(blackline);
        title.setTitleJustification(TitledBorder.LEFT);
        setBorder(title);

        this.checkCount = checkCount;

        addCheckPanel();
        addBtn();

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 300);
    }

    public void addCheckPanel() {
        chkPanel = new JPanel();
        chkPanel.setLayout(new BoxLayout(chkPanel, BoxLayout.Y_AXIS));
        for (int i = 0; i < checkCount; i++) {
            addCheck();
        }
        add(chkPanel);
    }

    public void addCheck() {
        JCheckBox check = new JCheckBox("Check Me");
        chkPanel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox cb = (JCheckBox) e.getSource();
                if (cb.isSelected()) {
                    selectedCount++;
                } else {
                    selectedCount--;
                }
                if (selectedCount == checkCount) {
                    removeButton.setEnabled(true);
                }
            }
        });
    }

    public void addBtn() {
        removeButton = new JButton("Remove");
        add(removeButton, BorderLayout.SOUTH);
        removeButton.setEnabled(false);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source instanceof Component) {
                    Component comp = (Component) source;
                    Component myParent = comp.getParent();
                    Container yourParent = myParent.getParent();
                    yourParent.remove(myParent);
                    yourParent.revalidate();
                    yourParent.repaint();
                }
            }
        });
    }

}