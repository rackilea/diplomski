MobileElement element = (MobileElement) driver.findElementByClassName("android.widget.ListView"); 
JavascriptExecutor js = (JavascriptExecutor)driver; 
HashMap<String, String> scrollObject = new HashMap<String, String>(); 
scrollObject.put("direction", "down"); 
scrollObject.put("element", ((RemoteWebElement) element).getId());
scrollObject.put("text", "AUDI"); 
js.executeScript("mobile: scrollTo", scrollObject);