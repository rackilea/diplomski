public static void main(String args[]) throws Exception{
    SXSSFWorkbook workbook = new SXSSFWorkbook(100);
    SXSSFSheet sheet = workbook.createSheet("output");
     FileOutputStream f = new FileOutputStream("GAHzxvv123TESTvvvzxzzadage12.xlsx",true);

  // DRIVER

    WebDriver driver=new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://en.wikipedia.org/wiki/List_of_Death_Note_episodes");
    List<WebElement> Elements=driver.findElements(By.xpath("//table//tbody//td//i"));
    int x=-1;
    for(WebElement ele: Elements)
    {
        System.out.println(ele.getText());
        SXSSFRow dataRow = sheet.createRow((short)++x);
        SXSSFCell cell=dataRow.createCell(0);
        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        cell.setCellValue(ele.getText());
    }
    try {
        f.flush();
        workbook.write(f);
        f.close();
        System.out.println("Excel written successfully..");
        driver.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}