List<WebElement> element = driver.findElements(By.tagName("img"));

for(WebElement e:element) {    
  if(e.getAttribute("src").contains("images/temp/advertisement.png")){
       jse.executeScript("arguments[0].style.display = 'none'", e);
  }
}