boolean same = true;
for (int col = 0; col < columnCount; col++) {
    if (table.getValueAt(row, col ) != value) {
         same = false;
         break;
    }
}
if (same) {
    setValue("K");
}