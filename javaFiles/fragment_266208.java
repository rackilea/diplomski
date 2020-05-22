<%
ArrayList all = Locations.getAllLocations();
int size = all.size();
%>  
<%
for (int i = 0; i < size; i++) {
    ArrayList one = (ArrayList) all.get(i);
%>
<tr style="height:30px; padding:4px;">
    <td><div align="center"><a href="" onclick="getTownValue(this)" id="tname">           <%=(String) one.get(0)%></a></div></td>
    <td><div align="center"><%=(String) one.get(1)%></div></td>
    <td><div align="center"><%=(String) one.get(2)%></div></td>
</tr>
<% }%>