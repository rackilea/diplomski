private FeedbackPanel feedbackPanel;
feedbackPanel  = new FeedbackPanel("feedbackPanel") {
    @Override
    protected void onConfigure() {
        super.onConfigure(); 
        setVisible(anyMessage());
    }
};
feedbackPanel.setOutputMarkupPlaceholderTag(true);