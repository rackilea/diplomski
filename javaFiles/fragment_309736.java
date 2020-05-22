CheckTreeManager checkTreeManager = new CheckTreeManager(tree);
    TreePath checkedPaths[]=checkTreeManager.getSelectionModel().getSelectionPaths();
    int j = checkedPaths.length;
    System.out.println("Tree Path :"+j);

    for(int i=0; i<checkedPaths.length;i++){
        System.out.println("Tree Path :"+checkedPaths[i]);
    }