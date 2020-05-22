contactsGrid = new RefreshingView<User>("contactsGrid") {

        private static final long serialVersionUID = 6885639412244652087L;

        @Override
        protected Iterator<IModel<User>> getItemModels() {
            return new ModelIteratorAdapter<User>(getUserService().getUsers().values()) {

                @Override
                protected IModel<User> model(User user) {
                    return new CompoundPropertyModel<User>(new DetachableUserModel(user));
                }
            };
        }

        @Override
        protected void populateItem(final Item<User> item) {
            final IModel<User> user = item.getModel();
            item.add(new Label("id"));
            item.add(new TextField<String>("name").add(new AjaxFormComponentUpdatingBehavior("onchange") {

                @Override
                protected void onUpdate(AjaxRequestTarget target) {
                    item.setDefaultModelObject(user);
                }

            }));
            item.add(new TextField<String>("username").add(new AjaxFormComponentUpdatingBehavior("onchange") {

                @Override
                protected void onUpdate(AjaxRequestTarget target) {
                    item.setDefaultModelObject(user);
                }

            }));
            item.add(new TextField<String>("role").add(new AjaxFormComponentUpdatingBehavior("onchange") {

                @Override
                protected void onUpdate(AjaxRequestTarget target) {
                    item.setDefaultModelObject(user);
                }

            }));
            item.add(new CheckBox("deleted").add(new AjaxFormComponentUpdatingBehavior("onchange") {

                @Override
                protected void onUpdate(AjaxRequestTarget target) {
                    item.setDefaultModelObject(user);
                }

            }));
            item.add(new ActionPanel("actions", user));
        }

    };