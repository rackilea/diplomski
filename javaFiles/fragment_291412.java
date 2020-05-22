@FindBy(id = "q")
WebElement element;

@FindBy(id = "q")
List<WebElement> listOfElements;

public void someMethod() {
    //can't use `isEmpty()` on `element` because it's NOT a list
    listOfElements.isEmpty(); //that's how you can use it
}