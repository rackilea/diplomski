psDetail=conn.prepareStatement(sqlDetail);
rsDetail=psDetail.executeQuery();
if(rsDetail.next()){ // moves to first row
%>

 <h2> <%=rsDetail.getString("bookPrice")%> </h2>

 <% } %>