List<MyDbRow> rows = new ArrayList<>();
for (Object[] filaRad : listaRad) {
    MyDbRow row = new MyDbRow();
    row.setId(fileRad[0]); //may require casting
    row.setName(fileRad[1]);

    rows.add(row);
}