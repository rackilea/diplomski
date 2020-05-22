HashMap<String,Node> nodes = new HashMap<String,Node>();

Transaction tx=graphDb.beginTx();       
    Connection conn = null;
    try{{       
    conn=ConnectionFactory.getConnection();
    Statement stat=conn.createStatement();
    String sql="select * from Fade where App_Int_Id < 22";
    ResultSet rs=stat.executeQuery(sql);        
    String n1 = "",n2="",rel="",type="";
    while(rs.next()){
        n1=rs.getString(1);              
        n2=rs.getString(7);
        rel=rs.getString(3);    
        type=rs.getString(4);           

    Node first=nodes.get(n1);

    // Only create it if it didn't already exist.
    if(first == null) { 
       first = graphDb.createNode();
       first.setProperty("name", n1);
       first.addLabel(DynamicLabel.label(n1));

       // Now put it in the map to ensure it doesn't get created again.
       nodes.put(n1, first);
    } 

    Node sec=nodes.get(n2); 

    if(sec == null) { 
       sec = graphDb.createNode();
       sec.setProperty("name", n2);
       sec.addLabel(DynamicLabel.label(n2));       

       // Now put it in the map to ensure it doesn't get created again.
       nodes.put(n2, sec);
    } 

    RelationshipType KNOWS = DynamicRelationshipType.withName(rel);

    if(type.equalsIgnoreCase("Incoming")){
        sec.createRelationshipTo(first, KNOWS);     
    }
    else if(type.equalsIgnoreCase("Outgoing")){
        first.createRelationshipTo(sec, KNOWS);     
    }