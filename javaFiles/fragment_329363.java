for(int i = 0; i < favoriteList.length; i++) {  

    String url = favoriteList[i].getUrl();
    out.println("<tr>");
    out.println("<td>");

    out.println(" <form id=\"countForm" + i + "\"  method=\"POST\">");
    out.println(" <input type=\"hidden\" name=\"favoriteID\" value=\""
                    + favoriteList[i].getFavoriteId() + "\" />");
    out.println("<a" 
        + " href =\" javascript:document.countForm" + i + ".submit();\""
    + "  onclick=\"document.getElementById('countForm" + i + "').submit();\"" + " />" + url + "</a>");       
    out.println("</form>");

    out.println("</td> <tr> <td>");
    out.println("<p>" + favoriteList[i].getComment() + "</p>" );
    out.println("</td></tr> <tr><td>");
    out.println("<p>" + favoriteList[i].getClickCount() + "</p>");
    out.println("</td></tr>");
}