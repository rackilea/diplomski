List<WebElement> elements = driver.findElements(By.xpath("//*[@class='element']//p"));

for(int i=0; i<elements.size(); i++) {
    WebElement p = elements.get(i);
    String lines[] = p.getText().split("\\r?\\n");
    for(String line: lines) {
        System.out.println("line :" +line);
    }
}