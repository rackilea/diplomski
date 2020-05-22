TextBox suggestTextBox = new TextBox();
    suggestTextBox.addClickHandler(new ClickHandler() {

        @Override
        public void onClick(ClickEvent event) {
            Window.alert("tada");
        }
    });
    SuggestOracle oracle = new MultiWordSuggestOracle(" ,");

    final SuggestBox nameField = new SuggestBox(oracle, suggestTextBox);