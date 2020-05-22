Webelement elm = driver.findElement(By.id("13"));
String c_elm = elm.getAttribute("class")
if c_elm.contains("inactive"){
    System.out.println("button is disabled")
}
else{
    System.out.println("button is enabled")
}