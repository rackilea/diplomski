VBox root = new VBox();
    root.setAlignment(Pos.TOP_CENTER);

    // Generate menu from sqlbrowser.menu.CreatingMenus;
    menu = new CreatingMenus();
    menu.initMenu(primaryStage, root);
    // Generate Data table navigation from sqlbrowser.navigation.Navigation;
    navigation = new Navigation();
    navigation.initNavigation(primaryStage, root);

    Scene scene = new Scene(root, xSize, ySize, backgroundColor);
    primaryStage.setScene(scene);
    primaryStage.show();