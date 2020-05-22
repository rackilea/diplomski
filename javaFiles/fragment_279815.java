IWebElement top= driver.findelement( put you locator top here )
 IWebElement bottom = driver.findelement( put you bottom here)
 if(top!=null)
 {
  if(top.IsDisplayed)
  {
   top.click()
  }
}
else
{
  if(bottom!=null)
  {
    bottom.click()
  }
}