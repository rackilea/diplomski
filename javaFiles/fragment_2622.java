public void highlightElement(Driver, IWebElement element) 
    {
        for (int i = 0; i < 2; i++)
        {
            IJavaScriptExecutor js = (IJavaScriptExecutor) Driver;
            js.ExecuteScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow;  border: 2px solid yellow;");
            if (element.GetAttribute("style") != null)
            {
                Thread.Sleep(5000);
            }
            js.ExecuteScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
        }
    }