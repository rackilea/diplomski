JSONObject jsonObj = new JSONObject(jsonString.toString()); //convert to json object
JSONArray objSearchOrdersDto = jsonObj.getJSONArray("objSearchOrdersDto"); // convert to json array


XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Report");

        int rowCount = 0;
        for (int i = 0; i < objSearchOrdersDto.length(); ++i)
        {
            JSONObject rec = objSearchOrdersDto.getJSONObject(i);
            int OrderNumber = rec.getInt("OrderNumber");
            String strStatusType = rec.getString("strStatusType");
            int OrgUnitId = rec.getInt("OrgUnitId");

            Row row = sheet.createRow(++rowCount);
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(OrderNumber);
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(strStatusType);
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(OrgUnitId);
            System.out.println(OrderNumber+"\t"+strStatusType+"\t"+OrgUnitId); //want to excel file for this three field
        }


        try (FileOutputStream outputStream = new FileOutputStream("Report.xlsx")) {
            workbook.write(outputStream);
        }