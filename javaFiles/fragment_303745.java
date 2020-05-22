<%  
    String instockMessage = (String) pageContext.getAttribute("instockMessage");
    if ((instockMessage != null) && (instockMessage.trim().length() != 0)) {
        instockMessage = instockMessage.replaceAll("<[^>]*>", "").trim();
        pageContext.setAttribute("instockMessage", instockMessage);
    }
%>