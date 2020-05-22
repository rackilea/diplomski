final IModel<String> textModel = Model.of("initial text");
    final Label result = new Label("result", textModel);
    result.setOutputMarkupId(true);
    add(result);

    Form<String> form = new Form<>("form", textModel);
    add(form);

    AjaxEditableMultiLineLabel<String> textArea = new AjaxEditableMultiLineLabel<String>(
            "text", textModel) {

        private static final long serialVersionUID = 1L;

        private boolean initialized = false;

        private FormComponent<String> editor;

        @Override
        public void onEdit(AjaxRequestTarget target) {
            super.onEdit(target);
            if(!initialized) {
                String editorId = editor.getMarkupId();
                String resultId = result.getMarkupId();
                StringWriter sw = new StringWriter();
                sw.write("$('#");
                sw.write(editorId);
                sw.write("').keyup(function() { var str = $('#");
                sw.write(editorId);
                sw.write("').val(); ");
                sw.write("$('#");
                sw.write(resultId);
                sw.write("').html(str); });");
                String js = sw.toString();
                System.out.println("Appending editor JS " + js);
                target.appendJavaScript(js);
                initialized = true;
            }
        }

        @Override
        protected FormComponent<String> newEditor(MarkupContainer parent,
                String componentId, IModel<String> model) {
            editor = super.newEditor(parent, componentId, model);
            return editor;
        }

    };

    textArea.setCols(50);
    textArea.setRows(20);

    form.add(textArea);
    form.add(new SubmitLink("submit"));