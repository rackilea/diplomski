<%
    String firstNumParameter =  new org.displaytag.util.ParamEncoder("tableRow").encodeParameterName(org.displaytag.tags.TableTagParameters.PARAMETER_PAGE);

    if(request.getParameter(firstNumParameter ) == null) {
        pageContext.setAttribute("clear1Status", "true");

    }else{
        pageContext.setAttribute("clear1Status", "false");
    }
%>