Button button = new Button("Button", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                table.setContainerDataSource(container);
            }
        });