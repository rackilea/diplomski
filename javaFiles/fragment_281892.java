private class ProcessAfterCloseBehavior extends AbstractDefaultAjaxBehavior {
        @Override
        public void renderHead(Component component, IHeaderResponse response) {
            super.renderHead(component, response);
            response.render(new OnDomReadyHeaderItem("window.onbeforeunload = function (e) {"
                    + getCallbackScript() + "};"));
        }

        @Override
        protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
            attributes.setAsynchronous(false);
        }

        @Override
        protected void respond(AjaxRequestTarget target) {
            //Do whatever you need to do.
        }
}