JavascriptExecutor js = (JavascriptExecutor)driver;
clickSearch(js);

public void clickSearch(JavascriptExecutor js)
{
    js.executeScript("arguments[0].click()", sOmEtHiNg);
}