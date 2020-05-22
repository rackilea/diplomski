selectOption("EMA");

public void selectOption(String option)
{
    // @formatter:off
    String script =
        "function selectOption(s) {\r\n" +
        "   var sel = document.querySelector('select.departurePoint.airportSelect');\r\n" +
        "   for (var i = 0; i < sel.options.length; i++)\r\n" +
        "   {\r\n" +
        "       if (sel.options[i].text.indexOf(s) > -1)\r\n" +
        "       {\r\n" +
        "           sel.options[i].selected = true;\r\n" +
        "           break;\r\n" +
        "       }\r\n" +
        "   }\r\n" +
        "}\r\n" +
        "return selectOption('" + option + "');";

    // @formatter:on
    ((JavascriptExecutor) driver).executeScript(script);
}