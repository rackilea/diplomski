<%! String s1 = ""; %>
    <% s1  = (String) session.getAttribute("email");%>
    <% if(s1.equals("exist")){ %>
    <div class="besideemailbox" style="color : red">Email Already exist</div>
    <% }else if(s1.equals("something")){ %>
    <div class="besideemailbox" style="color : green">ok or a tick</div>
    <% } %>