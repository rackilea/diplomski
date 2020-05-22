while(rs.next())  
 {  
    out.println("<tr>"
    String[] rowData = new String[colCount];
    for(int i =0; i<colCount; i++){
       rowData[i] =  rs.getString(i+1);
       out.println("<td>"+rowData[i]+"</td>");
    }
    out.println("</tr>");
 } 
 out.println("</table>"); ///write this outside while loop