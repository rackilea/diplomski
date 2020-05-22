Object cellObj = model.getValueAt(i,j);
String s;
if (cellObj == null) {
    s = null;
} else {
    s = cellObj.toString();
}