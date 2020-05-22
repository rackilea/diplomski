List<WebElement> rows = driver.findElements(By.className("Grp"));
logger.info("number of rows: " +rows.size());
ArrayList<String> list = new ArrayList<>();

for (WebElement row : rows)    
{
        if (row.getText().trim().contains("Text"))
            { 
                logger.info("text: " + row.getText().trim());
                list.add(row.getText().trim());
            }
}