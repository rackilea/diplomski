public class ExcelCustomerReport {

    public ExcelCustomerReport() {
    }

    public void exportTable(JTable table, File file) throws IOException {
        TableModel model = table.getModel();
        FileWriter out = new FileWriter(file);
        String groupExport = "";
        for (int i = 0; i < (model.getColumnCount()); i++) {//* disable export from TableHeaders
            groupExport = String.valueOf(model.getColumnName(i));
            out.write(String.valueOf(groupExport) + "\t");
        }
        out.write("\n");
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < (model.getColumnCount()); j++) {
                if (model.getValueAt(i, j) == null) {
                    out.write("null" + "\t");
                } else {
                    groupExport = String.valueOf(model.getValueAt(i, j));
                    out.write(String.valueOf(groupExport) + "\t");
                }
            }
            out.write("\n");
        }
        out.close();
    }
}