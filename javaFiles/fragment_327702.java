<%
    Navigation navRoot = new Navigation(currentPage,2,new PageFilter(request),4);
    for (Navigation.Element e: navRoot) {
        switch (e.getType()) {
            case NODE_OPEN:
            %><ul><%
                break;
            case ITEM_BEGIN:
                %><li ><a href="<%= e.getPath() %>.html"><%=     e.getTitle() %></a> <%
                break;
            case ITEM_END:
            %></li><%
                break;
            case NODE_CLOSE:
            %></ul><%
                break;
        }
    }

    %>