multichoice.add(new AjaxFormComponentUpdatingBehavior("onchange") {
        private static final long serialVersionUID = 1L;

        @Override
        protected void onUpdate(AjaxRequestTarget target) {
            List<User> users = (List<User>) properties.get("selectedUsers");   
            // do whatever you want to do with the users list
        }
    };