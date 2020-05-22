<select id="stockListDropdown">
<% 
    ArrayList stockList = db.getUserStocks(userid);
    for (Stock s : stockList) {
%>
        <option value="<%=s.getValue()%>"><%=s.getName()%></option>
<%  }  %>
</select>