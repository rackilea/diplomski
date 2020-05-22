//    tab1.setUserData(labelUpdater);
    countLabel.setUserData(labelUpdater);

    TabPane tabPane = new TabPane(tab1, new Tab("tab2"));
    tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue != null) {
            Node content = newValue.getContent();
            if (content != null) {
                Runnable updater = (Runnable) content.getUserData();
                if (updater != null) {
                    updater.run();
                }
            }
        }
    });