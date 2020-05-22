public MoveFolders(DefaultListModel<String> model1) {
        ...
        fromModel = new DefaultListModel<>();
        for (Object obj : model1.toArray()) {
            fromModel.addElement((String) obj);
        }
        toModel = new DefaultListModel<>();
        theModel = model1;
        ...
    }