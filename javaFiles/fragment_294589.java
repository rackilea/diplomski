String query = "insert into Product (product_id,product_name,product_description,product_price) VALUES (?,?,?,?)";
ps=connection.prepareStatement(query);
ps.setInt(1,product_id);
...
ps.executeUpdate();

query="insert into PC(product_id,component_id) VALUES (?,?)";
ps=connection.prepareStatement(query);
String []component_ids=request.getParameterValues("component_id");
for(String componentID: components_ids){
   ps.setString(1,product_id);
   ps.setString(2,componentID);
   ps.executeUpdate();
}