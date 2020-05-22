private void exportPermissionDataToExcel(SortedMap allPermissions, HttpServletResponse response) {

    PropertyManager props = ResourcesProperties.getInstance();

    HSSFWorkbook wb = null;
    try {

        String headerString = "attachment; filename=\"" + EXCEL_FILE_NAME + ".xls\";";
        wb = new HSSFWorkbook();

        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style.setFont(font);

        HSSFSheet workSheet = wb.createSheet(EXCEL_FILE_NAME);
        workSheet.createRow(1);

        int columnNumber = 0;

        for (Object pair : allPermissions.entrySet()) {

            Object key = ((Map.Entry) pair).getKey();
            Object values = ((Map.Entry) pair).getValue();

            int rowNumber = 0;
            Row row = workSheet.createRow(rowNumber);
            Cell cell = row.createCell(columnNumber);
            rowNumber++;

            if (key instanceof User) {
                cell.setCellValue(((User) key).getFullName() + " (" + ((User) key).getUsername() + ")");
            } else {
                cell.setCellValue(((Group) key).getName());
            }
            cell.setCellStyle(style);

            for (Object permissionsList : (List) values) {
                for (Object permissionValue : ((Map) permissionsList).entrySet()) {

                    Object key1 = ((Map.Entry) permissionValue).getKey();
                    Object listOfValues1 = ((Map.Entry) permissionValue).getValue();

                    columnNumber = 1;
                    row = workSheet.createRow(rowNumber);
                    cell = row.createCell(columnNumber);
                    rowNumber++;
                    cell.setCellValue(props.getProperty(key1.toString()));
                    cell.setCellStyle(style);

                    for (Object permissionsList1 : (List) listOfValues1) {

                        for (Object permissionMap : (List) permissionsList1) {

                            for (Object permissionMap1 : ((Map) permissionMap).entrySet()) {

                                Object key2 = ((Map.Entry) permissionMap1).getKey();
                                Object listOfValues2 = ((Map.Entry) permissionMap1).getValue();

                                columnNumber = 2;
                                //if property not found returns null, some records can be already transalted, translations for translations cannot be found => null
                                String message2 = props.getProperty(key2.toString());
                                if (message2 == null) {
                                    rowNumber = createCellAndSetValue(workSheet, row, cell, rowNumber, columnNumber,key2.toString());
                                } else {
                                    rowNumber = createCellAndSetValue(workSheet, row, cell, rowNumber, columnNumber, message2);
                                }

                                if (!key1.equals("lv.alise.usermanager.permissions.ConnectPermission")) {

                                    for (Object permissionValue3 : (List) listOfValues2) {
                                        if (key1.equals("lv.alise.usermanager.permissions.WorkflowPermission")) {

                                            for (Object permissionMap2 : ((Map) permissionValue3).entrySet()) {

                                                Object key3 = ((Map.Entry) permissionMap2).getKey();
                                                Object listOfValues3 = ((Map.Entry) permissionMap2).getValue();

                                                columnNumber = 3;
                                                rowNumber = createCellAndSetValue(workSheet, row, cell, rowNumber, columnNumber,props.getProperty(key3.toString()) );

                                                for (Object permissionValue4 : (List) listOfValues3) {
                                                    columnNumber = 4;
                                                    rowNumber = createCellAndSetValue(workSheet, row, cell, rowNumber, columnNumber,props.getProperty(permissionValue4.toString()) );
                                                }
                                            }
                                        } else {
                                            columnNumber = 3;
                                            rowNumber = createCellAndSetValue(workSheet, row, cell, rowNumber, columnNumber,props.getProperty(permissionValue3.toString()) );
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        response.setContentType("application/octetstream");
        response.setHeader("Content-Disposition", headerString);
        OutputStream out = response.getOutputStream();
        wb.write(out);
        out.close();
        wb.close();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

private int createCellAndSetValue(HSSFSheet workSheet, Row row, Cell cell, int rowNumber, int columnNumber, String value) {
    row = workSheet.createRow(rowNumber);
    cell = row.createCell(columnNumber);
    rowNumber++;
    cell.setCellValue(value);
    return rowNumber;
}