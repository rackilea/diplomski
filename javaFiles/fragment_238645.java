import java.awt.*;
import java.util.Stack;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TestTable {

    private String[] colNames = { "Col 1", "Col2", "Col3", "Col4", "Col5" };

    private DefaultTableModel model = new DefaultTableModel(colNames, 0);
    private JTable table = new JTable(model);
    private MyStack myStack = new MyStack();
    private Stack<Integer[]> stack;

    private JButton button = new JButton("Add Row");

    public TestTable() {
        stack = myStack.getStack();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!stack.isEmpty()) {
                    Integer[] array = stack.pop();
                    model.addRow(array);
                }
            }
        });

        JFrame frame = new JFrame();
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestTable();
            }
        });
    }
}

class MyStack {
    public Stack<Integer[]> stack = new Stack<Integer[]>();

    public MyStack() {
        int k = 1;
        for (int i = 0; i < 20; i++) {
            Integer[] array = new Integer[5];
            for (int j = 0; j < 5; j++) {
                array[j] = i * k * (j + 1);
            }
            k++;
            stack.push(array);
        }
    }

    public Stack<Integer[]> getStack() {
        return stack;
    }
}