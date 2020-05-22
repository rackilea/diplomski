private TextArea textarea() {
    TextArea textarea = new TextArea("textarea", new PropertyModel<String>(this, "value")){

        @Override
        protected void onConfigure() {
            setEnabled(condition());
        }

    };
    textarea.setOutputMarkupId(true);
    textarea.add(new AjaxFormComponentUpdatingBehavior("blur") {

        @Override
        protected void onUpdate(AjaxRequestTarget target) {
        }
    });
    return textarea;
}