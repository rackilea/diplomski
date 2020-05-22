WebElement table2 = driver.findElement(By.cssSelector("body > div:nth-child(74) > div.sp-palette-container"));
List<WebElement> allrows2 = table2.findElements(By.tagName("div"));

int rowSize, cellSize = 0;
rowSize = allrows2.sie();

for(int rowIndex=0;rowIndex<rowSize;rowIndex++){
    WebElement row2 = allrows2.get(rowIndex);
    List<WebElement> cells = row2.findElements(By.tagName("span"));
    cellSize = cells.size();

    for(int cellIndex=0;cellIndex<cellSize;cellIndex++){
        WebElement cell = cells.get(cellIndex);

        if (cell.getAttribute("title").equals("rgb(0, 158, 236)")) {
            cell.click();
            // find cells again on "new" page
            cells = row2.findElements(By.tagName("span"));
             // find rows again on "new" page
            allrows2 = table2.findElements(By.tagName("div"));
        }
    }
}