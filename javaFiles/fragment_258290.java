tabs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

    @Override
    public void changed(ObservableValue<? extends Tab> observable, Tab oldSelectedTab, Tab newSelectedTab) {
        if(newSelectedTab == newtab) {
            final Tab tab = new Tab(browseR.getWebTitle());
            tabs.getTabs().add(tab);

            Browser newBrowser = new Browser();
            tab.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
                if (isNowSelected) {
                    displayedBrowser = newBrowser ;
                }
            });

            tabs.getSelectionModel().select(tab);

            tab.setContent(newBrowser);

            loadFavicon(addressBar.getText(),tab);
        }
    }

});