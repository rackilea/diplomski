final DateField x = new DateField();

    final InlineDateField y = new InlineDateField();

    HorizontalLayout layout = new HorizontalLayout();
    layout.setSpacing(true);

    layout.addComponent(x);
    layout.addComponent(y);

    Button button = new Button("Today");

    layout.addComponent(button);

    button.addClickListener(new Button.ClickListener() {
        public void buttonClick(ClickEvent event) {
            Date date = new Date();
            x.setValue( date );
            y.setValue( date );
        }
    });



    this.setContent(layout);