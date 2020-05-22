JTableHeader header = table.getTableHeader();
header.setReorderingAllowed(false);
header.addMouseListener(new MouseAdapter() {  
    public void mouseClicked(MouseEvent e) {  
         int col = header.columnAtPoint(e.getPoint());  
         StringSelection selection = new StringSelection(table.getColumnName(col));
         Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
         clipboard.setContents(selection, selection);
       }  
   });