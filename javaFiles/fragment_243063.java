import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableCreatingDemo {
   public static void main(String args[]) {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Object rowData[][] = {
            { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
            { "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
      Object columnNames[] = { "Column One", "Column Two", "Column Three" };

      final DefaultTableModel model = new DefaultTableModel(rowData,
            columnNames);
      JTable table = new JTable(model);

      JScrollPane scrollPane = new JScrollPane(table);

      JPanel btnPanel = new JPanel();
      btnPanel.add(new JButton(new AbstractAction("Add Data") {

         @Override
         public void actionPerformed(ActionEvent e) {
            int rows = model.getRowCount() + 1;
            String[] rowData = new String[3];
            for (int i = 0; i < rowData.length; i++) {
               rowData[i] = String.format("Row%d-Column%d", rows, (i + 1));
            }
            model.addRow(rowData);
         }
      }));

      frame.add(scrollPane, BorderLayout.CENTER);
      frame.add(btnPanel, BorderLayout.PAGE_END);
      // frame.setSize(300, 150);
      frame.pack();
      frame.setVisible(true);

   }
}