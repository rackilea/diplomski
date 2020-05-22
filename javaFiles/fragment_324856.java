final IModel<String> textModel = Model.of("initial text");

    Form<String> form = new Form<>("form", textModel);
    add(form);

    AjaxEditableMultiLineLabel<String> textArea = new AjaxEditableMultiLineLabel<String>(
            "text", textModel) {

        private static final long serialVersionUID = 1L;

        @Override
        protected FormComponent<String> newEditor(MarkupContainer parent,
                String componentId, IModel<String> model) {
            final FormComponent<String> editor = super.newEditor(parent,
                    componentId, model);

            editor.add(new AjaxFormComponentUpdatingBehavior("keyup") {

                private static final long serialVersionUID = 1L;

                @Override
                protected void onUpdate(AjaxRequestTarget target) {
                    System.out.println("Ajax update for textArea " + editor.getDefaultModelObjectAsString());

                }
            });

            return editor;
        }

    };

    textArea.setCols(50);
    textArea.setRows(20);

    form.add(textArea);
    form.add(new SubmitLink("submit"));

    add(new Label("result", textModel));