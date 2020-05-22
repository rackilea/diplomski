DefaultTableModel model = new DefaultTableModel();
model.addColumn("Purpose");
model.addColumn("Name");
model.addColumn("Composition");
model.addColumn("Expiry");
model.addColumn("Stock");
model.addColumn("Cost");
model.addColumn("Type");
model.addColumn("Supplier");
model.addColumn("Supplier Number");
model.addColumn("Rack");

for (int index = 0; index < 10; index++) {

    Vector vector = new Vector();
    vector.add("p" + index);
    vector.add("n" + index);
    vector.add("c" + index);
    vector.add("e" + index);
    vector.add("s" + index);
    vector.add("c" + index);
    vector.add("t" + index);
    vector.add("s" + index);
    vector.add("s" + index);
    vector.add("r" + index);

    model.addRow(vector);

}

JTable table = new JTable(model);

try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Test.txt")))) {
    StringJoiner joiner = new StringJoiner(",");
    for (int col = 0; col < table.getColumnCount(); col++) {
        joiner.add(table.getColumnName(col));
    }
    System.out.println(joiner.toString());
    bw.write(joiner.toString());
    bw.newLine();
    for (int row = 0; row < table.getRowCount(); row++) {
        joiner = new StringJoiner(",");
        for (int col = 0; col < table.getColumnCount(); col++) {
            Object obj = table.getValueAt(row, col);
            String value = obj == null ? "null" : obj.toString();
            joiner.add(value);
        }
        System.out.println(joiner.toString());
        bw.write(joiner.toString());
        bw.newLine();
    }
} catch (IOException exp) {
    exp.printStackTrace();
}