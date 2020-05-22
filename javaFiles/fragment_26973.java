private class InputForm extends Form implements IHeaderContributor {

    private List<String> checkboxIds = new ArrayList();
    //...
        protected void populateItem(ListItem<NameWrapper> item) { 
            // PropertyModel can be used on Models, too, 
            // not necessarily modelObejcts.
            IModel checkboxModel = new PropertyModel<Boolean>(item.getModel(), "selected"));
            final CheckBox checkBox = new CheckBox("check", checkboxModel);                                 
            checkBox.setOutputMarkupId(true);

            // If checkboxMarkupId is null at this point, 
            // you can always set it this way
            // checkBox.setMarkupId("check" + item.getIndex());

            String checkboxMarkupId = checkBox.getMarkupId();
            checkboxIds.add(checkboxMarkupId);            
            item.add(checkBox); 
            String js = "deselectChecks('" + checkboxMarkupId + "');";
            checkbox.add(new SimpleAttributeModifier("onchange", js));
        }
    //...
    public void renderHead(IHeaderResponse response) {
        String jsArrDecl = "var checkIds = [";
        for (String checkId : checkboxIds){
            jsArrDecl += "'" + checkId + "', ";
        }
        jsArrDecl = jsArrDecl.substring(0, jsArrDecl.length()-1);
        jsArrDecl += "];";
        response.renderOnDomReadyJavascript(jsArrDecl);
    }
}