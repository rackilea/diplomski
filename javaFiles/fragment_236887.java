public String getRecentQueries(HttpServletRequest request)
{
    String queries = "";
    Enumeration e = request.getParameterNames();

    if ( e.hasMoreElements() )
    {
        queries += "<h4>Recent Queries</h4><ul>";
    }

    while ( e.hasMoreElements() )
    {
        String name = (String) e.nextElement();
        String value = (String) request.getParameter(name);
        queries += "<li><a href=\"" + value + "\">" + name + "</a></li>";
    }
    queries += "</ul></p>";

    return queries;
}