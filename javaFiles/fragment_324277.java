//This data needs to be written (Object[])
    Map< String, Object[] > empinfo =
            new TreeMap<>();
    empinfo.put( "1", new Object[] { "EMP ID", "EMP NAME", "DESIGNATION" });
    empinfo.put( "2", new Object[] { "tp01", "Gopal", "Technical Manager" });
    empinfo.put( "3", new Object[] { "tp02", "Manisha", "Proof Reader" });
    empinfo.put( "4", new Object[] { "tp03", "Masthan", "Technical Writer" });
    empinfo.put( "5", new Object[] { "tp04", "Satish", "Technical Writer" });
    empinfo.put( "6", new Object[] { "tp05", "Krishna", "6546984651685465132198651324984351" });

    //Iterate over data and write to sheet
    Set< String > keyid = empinfo.keySet();
    int rowid = 0;

    for (String key : keyid) {
        row = spreadsheet.createRow(rowid++);
        Object [] objectArr = empinfo.get(key);
        int cellid = 0;

        for (Object obj : objectArr) {
            Cell cell = row.createCell(cellid++);
            cell.setCellValue((String)obj);
        }
    }