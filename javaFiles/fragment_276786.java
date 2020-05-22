TreeItem<String> root = new TreeItem<String>("Root");

    TreeItem<String> item1 = new TreeItem<String>("Item 1");
    TreeItem<String> item11 = new TreeItem<String>("Item 1.1");
    TreeItem<String> item12 = new TreeItem<String>("Item 1.2");

    item1.getChildren().addAll(item11, item12);

    TreeItem<String> item2 = new TreeItem<String>("Item 2");

    root.getChildren().addAll(item1, item2);