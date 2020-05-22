//counter field declared in page class
        private int counter;

            ...

    form.add(new AjaxButton("ajax-button", new PropertyModel<String>(this,
            "counter", form)) {

        @Override
        protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
            counter++;
            target.addComponent(this);

        }
    });