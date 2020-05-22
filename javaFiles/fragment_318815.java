@Keyword
    public String navigatetoMainequitiesid(String navid){
        TestObject equitiesitem = getequitiesid(navid);
        WebUI.waitForElementPresent(equitiesitem,GlobalVariable.time_1)
        String abc = WebUI.getText(equitiesitem)
        return abc
    }