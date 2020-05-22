<%  
    String instockMessage = pageContext.getAttribute("instockMessage").toString();
    if ((instockMessage != null) && (instockMessage.trim().length() != 0)) {
        instockMessage = instockMessage.replaceAll("<[^>]*>", "").trim();
        pageContext.setAttribute("instockMessage", instockMessage);
    }
%>