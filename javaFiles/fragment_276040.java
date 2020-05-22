% Making changes to DefaultTableCellRenderer
% Give first column a header look, Center data
cr0 = javax.swing.table.DefaultTableCellRenderer();
cr0.setHorizontalAlignment(0) % 0 for CENTER, 2 for LEFT and 4 for RIGHT
cr0.setBackground(java.awt.Color(15790320)); % grey backgroundt
jtable.getColumnModel.getColumn(0).setCellRenderer(cr0);
jtable.getColumnModel.getColumn(0).setResizable(false);
jtable.getColumnModel.getColumn(0).setMaxWidth(32);