final AjaxEditableLabel label = new AjaxEditableLabel("value",
                new Model(value)) {

            @Override
            protected FormComponent newEditor(final MarkupContainer parent,
                    final String componentId, final IModel model) {
                final FormComponent newEditor = super.newEditor(parent,
                        componentId, model);
                newEditor.add(new RequiredStarBevaviour());
                return newEditor;
            }

            @Override
            public void onSubmit(final AjaxRequestTarget target) {
                super.onSubmit(target);
                // here I also try to get the editor
                // and add a SimpleAttributeModifier
                // with a javaScript for onBlur
                // event, but that script is not
                // working as I am not able to
                // append that script to the
                // editor's existing ajax
                final String input = (String) getModelObject();
                if (input != null) {
                    taskTypeSettingsFormModel.getTaskTypeList().set(index,
                            input);
                }
            }
        };