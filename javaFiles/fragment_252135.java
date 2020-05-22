//creating the cell
        Row row = my_sheet.createRow(0);                
        Cell cell = row.createCell(0);

        //creating helper class
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCreationHelper helper= workbook.getCreationHelper();

        //creating the hyperlink
        link = helper.createHyperlink(HSSFHyperlink.LINK_DOCUMENT);
        link.setAddress("'target_worksheet_name'!A1");

        //optional hyperlink style
        XSSFCellStyle hlinkstyle = workbook.createCellStyle();
        XSSFFont hlinkfont = workbook.createFont();
        hlinkfont.setUnderline(XSSFFont.U_SINGLE);
        hlinkfont.setColor(HSSFColor.BLUE.index);
        hlinkstyle.setFont(hlinkfont);

        //applying the hyperlink to the cell
        cell.setHyperlink(link);