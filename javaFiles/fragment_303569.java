@Test
public void f() throws Exception{
    //create source words list
    List<String> sourceWords = new ArrayList<String>();
    sourceWords.add("house");
    sourceWords.add("car");
    sourceWords.add("bed");
    System.out.println("Array length is " + sourceWords.size());

    List<String> transWords = new ArrayList<String>();

    //Iterate through the sourceWords list, search for each word and add result to transWords.
    for(String temp : sourceWords){
        driver.findElement(By.id("gt-tl-gms")).click();
        driver.findElement(By.xpath("/html/body/div[12]/table/tbody/tr/td[4]/div/div[7]/div")).click();
        driver.findElement(By.id("source")).sendKeys(temp);
        Thread.sleep(1000);
        String transRes = driver.findElement(By.id("result_box")).getText();

        transWords.add(transRes);

        driver.findElement(By.id("source")).clear();
    }

    //create workbook
    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet("new sheet");

    //add all the results
    int i=0;
    for (String transWord : transWords)
        Row row = sheet.createRow((short)i++);
        Cell cell = row.createCell(0);
        cell.setCellValue(transword);
    }

    //write to file
    FileOutputStream fileOut = new FileOutputStream("My/writeDataTest3.xls");
    workbook.write(fileOut);
    fileOut.close();
}