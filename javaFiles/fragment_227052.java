SXSSFWorkbook swb=null;
    XSSFSheet pivotSheet=null;
    AreaReference areaReference=null;
    if(wb instanceof SXSSFWorkbook ) {
        swb =(SXSSFWorkbook)wb;
        pivotSheet= swb.getXSSFWorkbook().createSheet("Pivot Sheet");
        SXSSFSheet sxssfDataSheet = (SXSSFSheet) sheet;
        areaReference = new AreaReference("A1:K"+(sxssfDataSheet.getLastRowNum() + 1), SpreadsheetVersion.EXCEL2007);
    }else {
        wb.createSheet("Pivot Sheet");
        pivotSheet = (XSSFSheet) wb.getSheetAt(1); 
        XSSFSheet  xssfDataSheet = (XSSFSheet) sheet;
        areaReference = new AreaReference("A1:K"+(xssfDataSheet.getLastRowNum() + 1), SpreadsheetVersion.EXCEL2007);
    }