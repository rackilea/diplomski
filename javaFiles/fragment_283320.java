boolean isDirCreated = false;//to create Screenshot directory just once

//Create Screenshot Directory.
public static void createDir(String ScreenshotDirAddress){
    if(!isDirCreated){
       File file= new File(ScreenshotDirAddress);
       if (!file.exists())
            file.mkdirs();
    isDirCreated=true;
    }
}


//hyperlink screenshot
public static void hyperlinkScreenshot(XSSFCell cell, String FileAddress){
    XSSFWorkbook wb=cell.getRow().getSheet().getWorkbook();
    CreationHelper createHelper = wb.getCreationHelper();
    CellStyle hlink_style = wb.createCellStyle();
    Font hlink_font = wb.createFont();
    hlink_font.setUnderline(Font.U_SINGLE);
    hlink_font.setColor(IndexedColors.BLUE.getIndex());
    hlink_style.setFont(hlink_font);
    Hyperlink hp = createHelper.createHyperlink(Hyperlink.LINK_FILE);
    FileAddress=FileAddress.replace("\\", "/");
    hp.setAddress(FileAddress);
    cell.setHyperlink(hp);
    cell.setCellStyle(hlink_style);
}

//take screenshot
public static void takeScreenShot(WebDriver driver, String screenshotName, XSSFCell cell){
    createDir();
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    try {
        String FullAddress=System.getProperty("user.dir")+"/"+ScreenshotDirAddress+"/"+screenshotName+".png";
        FileUtils.copyFile(scrFile, new File(FullAddress));
        hyperlinkScreenshot(cell, FullAddress);
    } catch (IOException e) {
        e.printStackTrace();
    }
}