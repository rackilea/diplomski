class Cave {
    public ArrayList< Party >                   parties = new ArrayList < Party > ();
    ...
    public JTree                                theTree;
    public DefaultMutableTreeNode               treeRoot = new DefaultMutableTreeNode( "Cave" );
    ...

    public Cave (){//Constructs Cave Object
        theTree                                            = new JTree( treeRoot );
    }
}//End Cave