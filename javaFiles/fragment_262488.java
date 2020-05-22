class Party extends Assets implements SearchableByName {
    ArrayList < Creature >                  members = new ArrayList < Creature > ();
    DefaultMutableTreeNode                  pNode;
    public void addMember ( Creature newMember ) {
    members.add ( newMember );
        newMember.cNode = addNode( newMember.getName(), this.pNode );
        newMember.tNode = addNode( "Treasures", newMember.cNode );//Each Creature hold Treasures
        newMember.aNode = addNode( "Artifacts", newMember.cNode );//Each Creature holds Artifacts
    }
    public Party ( String[] x ){//Party Consstructor
        index =                             Integer.parseInt( x[ 0 ] );
        name =                              x[ 1 ];
        pNode =                             addNode( this.getName(), SorcerersCave.theCave.treeRoot );//Creates new Parent node with treeNode as its parent
    }
}//End Party