public static List getItems(){ 
     PreparedStatement pStmt = null; 
     Connection conn = null; 
     boolean success = false; 
     ResultSet rs = null; 
     List ItemList = new ArrayList(); 

     try{ 
         conn = getConnection(); 

         String sql = "select * from Item"; 
         pStmt = conn.prepareStatement(sql); 

         rs = pStmt.executeQuery(); 
         while(rs.next()){ 
             Item item = new Item(); 
             item.setItemId(rs.getInt("ID")); 
             item.setItemName(rs.getString("NAME")); 
             ItemList.add(item); 
             } 



     }catch(Exception e){ 
         e.printStackTrace(); 

     }finally{ 
         closeConnectionProp(conn,pStmt,rs); 
     } 

     return ItemList;

}