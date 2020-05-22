public class ListPeopleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query q = new Query("Person");
        PreparedQuery pq = datastore.prepare(q);
        int pageSize = 15;

        resp.setContentType("text/html");
        resp.getWriter().println("<ul>");

        FetchOptions fetchOptions = FetchOptions.Builder.withLimit(pageSize);
        String startCursor = req.getParameter("cursor");

        // If this servlet is passed a cursor parameter, let's use it
        if (startCursor != null) {
            fetchOptions.startCursor(Cursor.fromWebSafeString(startCursor));
        }

        QueryResultList<Entity> results = pq.asQueryResultList(fetchOptions);
        for (Entity entity : results) {
            resp.getWriter().println("<li>" + entity.getProperty("name") + "</li>");
        }
        resp.getWriter().println("</ul>");

        String cursor = results.getCursor().toWebSafeString();

        // Assuming this servlet lives at '/people'
        resp.getWriter().println(
            "<a href='/people?cursor=" + cursor + "'>Next page</a>");
    }
}