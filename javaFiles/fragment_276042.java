data = {8.252,1.528,6.2598; 3.258,5.548,7.698; 4.448,9.5454,2.5644}; 
cols = {'A','B','C'}
DTM=javax.swing.table.DefaultTableModel(data,cols);
jtable = com.jidesoft.grid.SortableTable();
jtable.setModel(DTM);
jscroll = javax.swing.JScrollPane(jtable);
[htable,container] = javacomponent(jscroll,[5,5,500,400]);
set(container,'Units','norm');
javaaddpath('\ExternalSources\JavaExtenstions\CustomCellRenderer');
cr=CustomCellRenderer();
for i=0:2, jtable.getColumnModel.getColumn(i).setCellRenderer(cr), end;
jtable.repaint;