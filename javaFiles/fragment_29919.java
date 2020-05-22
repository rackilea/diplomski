import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

public class TestSortedTable {

    class MyTableModel extends AbstractTableModel {

        private List<Person> baseModel;

        public MyTableModel(List<Person> baseModel) {
            super();
            this.baseModel = new ArrayList<Person>(baseModel);
        }

        @Override
        public int getRowCount() {
            return baseModel.size();
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
            case 0:
                return "First Name";
            case 1:
                return "Last Name";
            }
            return null;
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
            case 0:
                return getPersonAtIndex(rowIndex).getFirstName();
            case 1:
                return getPersonAtIndex(rowIndex).getLastName();
            }
            return null;
        }

        public Person getPersonAtIndex(int rowIndex) {
            return baseModel.get(rowIndex);
        }

        public int getIndexOfPerson(Person person) {
            return baseModel.indexOf(person);
        }

    }

    protected void initUI() {
        List<Person> personModel = new ArrayList<TestSortedTable.Person>();
        personModel.add(new Person("John", "Smith"));
        personModel.add(new Person("Peter", "Donoghan"));
        personModel.add(new Person("Amy", "Peterson"));
        personModel.add(new Person("David", "Anderson"));
        JFrame frame = new JFrame(TestSortedTable.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Collections.shuffle(personModel);
        final MyTableModel table1Model = new MyTableModel(personModel);
        final JTable table1 = new JTable(table1Model);
        table1.setAutoCreateRowSorter(true);
        Collections.shuffle(personModel);
        final MyTableModel table2Model = new MyTableModel(personModel);
        final JTable table2 = new JTable(table2Model);
        table2.setAutoCreateRowSorter(true);
        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int index = table1.getSelectedRow();
                if (index > -1) {
                    int table1ModelIndex = table1.convertRowIndexToModel(table1.getSelectedRow());
                    Person p = table1Model.getPersonAtIndex(table1ModelIndex);
                    int table2ModelIndex = table2Model.getIndexOfPerson(p);
                    int indexInTable2 = table2.convertRowIndexToView(table2ModelIndex);
                    table2.getSelectionModel().setSelectionInterval(indexInTable2, indexInTable2);
                }
            }
        });
        table2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int index = table2.getSelectedRow();
                if (index > -1) {
                    int table2ModelIndex = table2.convertRowIndexToModel(table2.getSelectedRow());
                    Person p = table2Model.getPersonAtIndex(table2ModelIndex);
                    int table1ModelIndex = table1Model.getIndexOfPerson(p);
                    int indexInTable1 = table1.convertRowIndexToView(table1ModelIndex);
                    table1.getSelectionModel().setSelectionInterval(indexInTable1, indexInTable1);
                }
            }
        });
        frame.add(new JScrollPane(table1), BorderLayout.WEST);
        frame.add(new JScrollPane(table2), BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);
    }

    public class Person {
        private final String firstName;
        private final String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestSortedTable().initUI();
            }
        });
    }

}