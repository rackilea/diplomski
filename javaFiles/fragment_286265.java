@Override
protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
    super.updateAjaxAttributes(attributes); 
    attributes.getAjaxCallListeners().add(new IAjaxCallListener() {

        @Override
        public CharSequence getBeforeHandler(Component cmpnt) {
            return "$(\"#" + cmpnt.getMarkupId() + "\").hide()";
        }

        @Override
        public CharSequence getPrecondition(Component cmpnt) {
            return "";
        }

        @Override
        public CharSequence getBeforeSendHandler(Component cmpnt) {
            return "";
        }

        @Override
        public CharSequence getAfterHandler(Component cmpnt) {
            return "";
        }

        @Override
        public CharSequence getSuccessHandler(Component cmpnt) {
            return "";
        }

        @Override
        public CharSequence getFailureHandler(Component cmpnt) {
            return "";
        }

        @Override
        public CharSequence getCompleteHandler(Component cmpnt) {
            return "";
        }
    });
}