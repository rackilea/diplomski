//List will help of to determine the "Add secondary text" button needs to be clicked on not
//if the count is greater than 0 then click it
IList<IWebElement> elements = driver.FindElements(By.XPath("//span[contains(text(),'Add secondary text')]"));
if (elements.Count>0)
{
    elements.FirstOrDefault().Click();
}
IWebElement element = driver.FindElement(By.Id("sub-text"));
element.Clear();
element.SendKeys("Test");