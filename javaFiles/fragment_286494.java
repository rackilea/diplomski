import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class TestBunchARadios extends JPanel {
    private static final int GAP = 5;
    private String title = "Weekdays";
    private List<String> labels = Arrays.asList(new String[] { "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday" });
    private BunchARadios bunchARadios = new BunchARadios(title, labels);
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> selectionList = new JList<>(listModel);

    public TestBunchARadios() {
        selectionList.setPrototypeCellValue("xxxxxxxxxxxxxxxxx");
        selectionList.setVisibleRowCount(5);
        JScrollPane scrollPane = new JScrollPane(selectionList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new BorderLayout(GAP, GAP));
        add(bunchARadios, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.LINE_END);

        bunchARadios.addPropertyChangeListener(BunchARadios.SELECTION,
                new BunchARadiosChangeListener());
    }

    private class BunchARadiosChangeListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            String selection = (String) evt.getNewValue();
            listModel.addElement(selection);
        }
    }

    private static void createAndShowGui() {
        TestBunchARadios mainPanel = new TestBunchARadios();

        JFrame frame = new JFrame("TestBunchARadios");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}