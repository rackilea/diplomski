public String jsGetColor(String css){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("var x=$(\'"+css+"\');");
        stringBuilder.append("return x.css('color')");
        String res= (String) js.executeScript(stringBuilder.toString());
        return res;

    }