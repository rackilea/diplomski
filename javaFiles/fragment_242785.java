AjaxButton btn = new AjaxButton("button") {
    @Override
    protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
        super.onSubmit(target, form); 
        target.add(feedbackPanel);
    }
};