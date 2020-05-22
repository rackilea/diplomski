public interface SelectInput {
    boolean isMultiple();
    List<WebElement> getOptions();
    List<WebElement> getAllSelectedOptions();
    WebElement getFirstSelectedOption();
    void selectByVisibleText(String text);
    void selectByIndex(int index);
    void selectByValue(String value);
    void deselectAll();
    void deselectByValue(String value);
    void deselectByIndex(int index);
    void deselectByVisibleText(String text);
}