String getText(cssSel){
 JavascriptExecutor js = (JavascriptExecutor) driver;
        StringBuilder stringBuilder = new StringBuilder();

stringBuilder.append("var x = $(\""+cssSel+"\");");
        stringBuilder.append("return x.text().toString();")       ;


       String res= (String) js.executeScript(stringBuilder.toString());
}

text1=getText(cssLast);
text2=getText(csscssFirst);