TableModel model = table.getModel();
bw.write("<table>");
for(int r=0;r<model.getRowCount();++r) {
    bw.write("<tr>");
    for(int c=0;c<model.getColumnCount();++c) {
        bw.write("<td>");
        bw.write(model.getValueAt(r,c).toString());
        bw.write("</td>");
    }
}
bw.write("</table>");