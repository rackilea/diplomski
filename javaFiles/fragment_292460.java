List<WebElement> spans = driver.findElements(By.cssSelector(".nd_list span"));
int[] numbers = new int[spans.size()];
for (int i = 0; i < spans.size(); i++)
{
    numbers[i] = Integer.parseInt(spans.get(i).getText());
    System.out.println(numbers[i]);
}