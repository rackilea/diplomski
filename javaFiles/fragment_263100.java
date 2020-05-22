for(int j =0,i = 0; i<pNameList.size(); i++) {
     %> <tr> <% 
    if(i==0){      
    j++;    
       %> <td><%= j %></td> <%
    }else if(oIdList.get(i) != oIdList.get(i-1)){
    j++;

         %> <td><%= j %></td> <%
    }else{
         %> <td></td> <%

    }    
   %>                                      

  <td class="center"><%= pNameList.get(i) %></td>
  <td class="center"><%= pQtyList.get(i) %></td>
  <td class="center"><%= pTimeList.get(i) %></td>