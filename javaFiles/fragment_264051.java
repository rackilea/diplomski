String text = driver.findElement(By.xpath("//span[contains(., 'von')]" )).getText();
Pattern p = Pattern.compile("\d+ bis \d+ \(von (\d+)\)$");
Matcher m = p.matcher(text);

if (m.find()) {
    int value = Integer.parseInt(m.group(1));
}