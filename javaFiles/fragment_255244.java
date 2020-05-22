private List<BDE> dataList;
session = DaoSF.getSessionFactory('R').openSession();   
Criteria criteria = session.createCriteria(BDE.class);
  {some restrictions...}
dataList = criteria.list();

//Excel creation after your dataList has been generated 
FileOutputStream fos = new FileOutputStream("sth.xls");
//Give your file path may be to desktop so that you can see
org.apache.poi.hssf.usermodel.HSSFWorkbook workBook = new HSSFWorkbook();
Row row = null;
Cell cell = null;
Sheet sheet1 = workBook.createSheet();
    for(int rowNo = 0;rowNo<dataList.size;rowNo++){
     row= sheet1.createRow(rowNo);
      for(int cellNo = 0;cellNo <2;cellNo++){//It would go to 0th and 1st row
        cell = row.createCell(cellNo);
            cell.setCellValue("Some of your value");
            }
    }