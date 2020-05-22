// find the element and get the attribute value of onclick
String onClickValue = driver.findElement(By.xpath("//div[@class= 'taLnk hvrIE6 fl']")).getAttribute("onclick");

// split the onclick value on ','
String[] allTextArray = onClickValue.split(",");

// iterate through the array and is @ is contained with the text, print text
for (String text : allTextArray) {
    if (text.contains("@")) {
        System.out.println(text);
        return;
    }
}