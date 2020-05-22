Button bt = new Button("click");
    bt.addClickHandler(new ClickHandler() {

        @Override
        public void onClick(ClickEvent event) {
            Object soruce = event.getSource();

            if (soruce instanceof Button) {  //check that the source is really a button
                String buttonText = ((Button) soruce).getText();  //cast the source to a button
                RootPanel.get().add(new Label(buttonText));
            } else {
                RootPanel.get().add(new Label("Not a Button, can't be..."));
            }
        }
    });

    RootPanel.get().add(bt);