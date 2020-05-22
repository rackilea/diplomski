enum Field {

    FirstName,
    MiddleName,
    LastName,
    EMail,
    Password,
    Role,
    Status;
}

public void test() {
    while (iterator.hasNext()) {
        Row nextRow = iterator.next();
        Map<Field, String> values = new EnumMap(Field.class);
        for (Field f : Field.values()) {
            Cell cell = nextRow.getCell(f.ordinal());
            if (cell != null) {
                values.put(f, cell.getStringCellValue());
            }
        }
    }
}