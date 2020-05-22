@Test(priority = 1)
public void projectDelete() throws Exception {
    //find tbody
    WebElement table = webdriver.findElement(By.xpath("/table[@id='projectList']/tbody"));

    //get all rows
    List<WebElement> allRows = table.findElements(By.tagName("tr"));

    //iterate through the rows
    for (WebElement row : allRows) {
            //get the rowCells in each row
            List<WebElement> rowCells = row.findElements(By.tagName("td"));

            //get the column which contains the project name and get text
            String projectName = rowCells.get(indexofColumnwhichhasProjectname).getText();

            //Compare if the project name equals TEST1
            if (projectName.equals("TEST1")) {
                System.out.println("Table Data : " + projectName);
                System.out.println("Table Row : " + rowCells.indexOf(projectName));

                //get the column containing the link and click on it.
                rowCells.get(4).click();

                //webdriver.findElement(By.id("493")).click();
                //Img is contained within the row containing the project Name
                //So, find the Img in the row and click
                row.findElements(By.cssSelector("img[alt='Delete Project']")).click();                }
    }
}