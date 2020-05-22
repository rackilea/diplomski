String htmlFragment = "<div><button id='action1' type='button>Action 1<button/><div/>";

    HTMLPanel container = new HTMLPanel(htmlFragment);

    RootLayoutPanel.get().add(container);

    Element button1El = container.getElementById("action1");

    if(button1El != null){
        Button button1 = Button.wrap(button1El);
        button1.addClickHandler(new ClickHandler(){

            @Override
            public void onClick(ClickEvent event) {
                // What you want button 1 to do
            }

        });
    }