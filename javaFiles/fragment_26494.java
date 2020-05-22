List<List<String>> t2Rows = new ArrayList<List<String>>();

for (int i = 0; i < tbl_sale.getRowCount(); i++) {
    String pid = tbl_sale.getValueAt(i, 0).toString();
    String item = tbl_sale.getValueAt(i, 1).toString();
    String quant = tbl_sale.getValueAt(i, 2).toString();
    String rate = tbl_sale.getValueAt(i, 3).toString();
    String rs = tbl_sale.getValueAt(i, 4).toString();
    ArrayList<String> temp = new ArrayList<String>();
    temp.add(pid);//example I don't know the order you need
    temp.add(item);//example I don't know the order you need
    temp.add(quant);//example I don't know the order you need
    temp.add(rate);//example I don't know the order you need
    temp.add(rs);//example I don't know the order you need
    t2Rows.add(temp); 
}