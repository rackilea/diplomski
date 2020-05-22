@FindBy(how = How.CSS,using = "a[href='test.aspx?id=1']")
@CacheLookup
WebElement testlink;

public void ClickDress()
{
    System.out.println("testlink"+testlink);
    testlink.click();

}