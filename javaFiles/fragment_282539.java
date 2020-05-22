NodeConfig nc = Geth.newNodeConfig();
    try {
        Node node = Geth.newNode(getFilesDir() + "/.ethNode", nc);
        node.start();
        Thread.sleep(5000);
    }
    catch (Exception e){
    // Do something
    }