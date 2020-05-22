import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

public class TableExample {

    String[] title = new String[]{"Title A", "Title B"};
    Object[][] data = new String[][]{
        {"aaaaaaaaaaaa aaaaaa aaaaaaa", "bbbbbbbb bbbb bbbbbb bbbbbb"},
        {"cccccccccc cccccccc ccccccc", "ddddddd ddd dddddddd dddddd"},
        {"eeeeeeeeee eeeeeeee eeeeeee", "fffffff ffff ffffff fffffff"}};

    private JTable table;
    private JFrame frame;
    private DefaultTableModel model;
    private JScrollPane pane1;

    public JPanel createTable() {
        JPanel panel = new JPanel();
        //creating tables and table models
        model = new DefaultTableModel(data, title);
        table = new JTable(model);
        //enable table sorting
        table.setAutoCreateRowSorter(true);
        pane1 = new JScrollPane(table);
        panel.add(pane1);
        //delete a row after del keystroke
        keyBindings();
        return panel;
    }

    void showTable() {
        //create and show frame     
        JPanel testPanel = createTable();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(testPanel);
        frame.pack();
        frame.setVisible(true);
    }//showTable

    void keyBindings() {
        int condition = JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
        InputMap inputMap = table.getInputMap(condition);
        ActionMap actionMap = table.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "delete");
        actionMap.put("delete", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                row = table.convertRowIndexToModel(row);
                model.removeRow(row);
            }
        });
    }

    public static void main(String[] args) {
        TableExample example = new TableExample();
        example.showTable();
    }//main 

}//TableExample