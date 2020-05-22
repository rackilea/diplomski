add(new AjaxLink("customSubmitLink") {
    @Override public void onClick(AjaxRequestTarget target) {
        int aFieldValue = getRequest().getRequestParameters().getParameterValue("aField").toInt();
        // do something with aFieldValue
    }

    @Override protected void updateAjaxAttributes(AjaxRequestAttributes attrs) {
        super.updateAjaxAttributes(attrs);
        attrs.getDynamicExtraParameters().add("return {\"aField\": jQuery('#aFormField').val()});
    }
});