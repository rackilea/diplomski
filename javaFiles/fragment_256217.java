import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class Test2 extends JPanel {
    private static final int MAX_PERSONS = 111111;
    private DefaultListModel<Person> personModel = new DefaultListModel<>();
    private JList<Person> personJList = new JList<>(personModel);

    public Test2() {
        personJList.setPrototypeCellValue(new Person(11111111));
        personJList.setCellRenderer(new PersonRenderer());
        personJList.setVisibleRowCount(12);
        JScrollPane scrollPane = new JScrollPane(personJList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        for (int i = 0; i < MAX_PERSONS; i++) {
            personModel.addElement(new Person(i));
        }

        setLayout(new BorderLayout());
        add(scrollPane);
        add(new JButton(new AddPersonAction()), BorderLayout.PAGE_END);
    }

    private class AddPersonAction extends AbstractAction {
        public AddPersonAction() {
            super("Add Person");
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            Person p = new Person(166);
            personModel.addElement(p);
        }
    }

    private class PersonRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            if (value != null) {
                value = ((Person) value).getHeight();
            } else {
                value = "";
            }
            JComponent renderer = (JComponent) super.getListCellRendererComponent(list, value,
                    index, isSelected, cellHasFocus);

            // if you want a border around your renderer:
            renderer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            return renderer;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        Test2 mainPanel = new Test2();
        JFrame frame = new JFrame("Test2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}