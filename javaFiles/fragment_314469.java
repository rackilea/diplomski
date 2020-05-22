import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class SharedDataBetweenComboBoxSample {

    public static class MyComboBoxModel extends DefaultComboBoxModel implements ComboBoxModel, ListDataListener {
        private DefaultComboBoxModel original;

        public MyComboBoxModel(DefaultComboBoxModel original) {
            super();
            this.original = original;

        }

        @Override
        public int getSize() {
            return original.getSize();
        }

        @Override
        public Object getElementAt(int index) {
            return original.getElementAt(index);
        }

        @Override
        public void addListDataListener(ListDataListener l) {
            if (getListDataListeners().length == 0) {
                original.addListDataListener(this);
            }
            super.addListDataListener(l);
        }

        @Override
        public void removeListDataListener(ListDataListener l) {
            super.removeListDataListener(l);
            if (getListDataListeners().length == 0) {
                original.removeListDataListener(this);
            }
        }

        @Override
        public void addElement(Object anObject) {
            original.addElement(anObject);
        }

        @Override
        public void removeElement(Object anObject) {
            original.removeElement(anObject);
        }

        @Override
        public int getIndexOf(Object anObject) {
            return original.getIndexOf(anObject);
        }

        @Override
        public void insertElementAt(Object anObject, int index) {
            original.insertElementAt(anObject, index);
        }

        @Override
        public void removeAllElements() {
            original.removeAllElements();
        }

        @Override
        public void removeElementAt(int index) {
            original.removeElementAt(index);
        }

        @Override
        public void intervalAdded(ListDataEvent e) {
            fireIntervalAdded(this, e.getIndex0(), e.getIndex1());
        }

        @Override
        public void intervalRemoved(ListDataEvent e) {
            fireIntervalRemoved(this, e.getIndex0(), e.getIndex1());
        }

        @Override
        public void contentsChanged(ListDataEvent e) {
            fireContentsChanged(this, e.getIndex0(), e.getIndex1());
        }

    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final String labels[] = { "A", "B", "C", "D", "E", "F", "G" };

                final DefaultComboBoxModel model = new DefaultComboBoxModel(labels);

                JFrame frame = new JFrame("Shared Data");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel panel = new JPanel();
                JComboBox comboBox1 = new JComboBox(new MyComboBoxModel(model));
                comboBox1.setEditable(true);

                JComboBox comboBox2 = new JComboBox(new MyComboBoxModel(model));
                comboBox2.setEditable(true);
                panel.add(comboBox1);
                panel.add(comboBox2);
                frame.add(panel, BorderLayout.NORTH);

                JButton button = new JButton("Add");
                frame.add(button, BorderLayout.SOUTH);
                ActionListener actionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        model.addElement("New Added");
                    }
                };
                button.addActionListener(actionListener);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}