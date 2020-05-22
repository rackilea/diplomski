private void loadParentMibs throws SQLException () {

   ResultSet resultSet = Application.getDBHandler()
     .executeQuery(SQLQueries.SELECT_TABULARMIBS_PARENT);

   DefaultMutableTreeNode root = (DefaultMutableTreeNode)getRoot();

   Map<String, DefaultMutableTreeNode> parentsMap
     = new HashMap<String, DefaultMutableTreeNode>();

   while( resultSet.next() ) {  
     String parentId = resultSet.getString("mt_oid");

     DefaultMutableTreeNode parent = parentsMap.get(parentId);
     if ( parent == null ) {
       parent = new DefaultMutableTreeNode( parentId );
       parentsMap.add( parentId, parent );
       root.add( parent );
     }

       // Are you sure, you want Boolean.TRUE leafs 
       //   in number of parent coincindence?
       // May be you want leafs to contains some 
       //   additional info from resultSet entity?
     DefaultMutableTreeNode leaf = new DefaultMutableTreeNode(Boolean.TRUE);
     parent.add(leaf);
   }

 }