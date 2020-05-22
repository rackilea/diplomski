final RichTextArea tr = new RichTextArea();
    Button b = new Button("Test");
    b.addClickHandler(new ClickHandler() {

        @Override
        public void onClick(ClickEvent event) {
            setSelectionRange(tr.getElement(), 15, 20);
            tr.setFocus(true);
        }
    });
    RootPanel.get().add(tr);
    RootPanel.get().add(b);