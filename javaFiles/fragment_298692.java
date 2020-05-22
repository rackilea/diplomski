table.addMouseListener(new MouseAdapter() {

       public void mouseClicked(MouseEvent e) {
           JTable clickedTable = (JTable)e.getSource();
           int row = clickedTable.getSelectedRow();
           int col = clickedTable.getSelectedColumn();
           String input = JOptionPane.showInputDialog(getContentPane(), "message");

           //store data based on row and column
   }
});