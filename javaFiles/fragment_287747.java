import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            SortedListModel model = new SortedListModel();

            setLayout(new BorderLayout());
            add(new JScrollPane(new JList(model)));

            Random rnd = new Random();
            for (int index = 0; index < 100; index++) {
                int value = rnd.nextInt(100);

                model.add(value, "This is some data for " + index);
            }
        }

        public class SortedListModel extends AbstractListModel {

            private SortedSet<Data> model;

            public SortedListModel() {
                model = new TreeSet<>(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {
                        return o1.getIndex() - o2.getIndex();
                    }
                });
            }

            public void add(int index, Object value) {
                Data data = new Data(index, value);
                if (!model.contains(data)) {
                    model.add(data);
//                  int insertIndex = new ArrayList<Data>(model).indexOf(data);
                    int insertIndex = model.headSet(data).size();

                    fireIntervalAdded(data, insertIndex, insertIndex);
                }
            }

            @Override
            public int getSize() {
                return model.size();
            }

            @Override
            public Object getElementAt(int index) {
                return model.toArray()[index];
            }

            protected class Data {
                private int index;
                private Object value;

                public Data(int index, Object data) {
                    this.index = index;
                    this.value = data;
                }

                public Object getValue() {
                    return value;
                }

                public int getIndex() {
                    return index;
                }

                @Override
                public String toString() {
                    return getIndex() + ". " + getValue();
                }

                @Override
                public int hashCode() {
                    int hash = 7;
                    hash = 97 * hash + this.index;
                    hash = 97 * hash + Objects.hashCode(this.value);
                    return hash;
                }

                @Override
                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null) {
                        return false;
                    }
                    if (getClass() != obj.getClass()) {
                        return false;
                    }
                    final Data other = (Data) obj;
                    if (this.index != other.index) {
                        return false;
                    }
                    if (!Objects.equals(this.value, other.value)) {
                        return false;
                    }
                    return true;
                }



            }

        }
    }

}