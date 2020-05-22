@GET
@Path("{id}")
@Produces({"application/xml", "application/json"})
public WatchList find(@PathParam("id") Integer id) {
    WatchList results = em.createNamedQuery("WatchList.findById", WatchList.class)
            .setParameter("id", id)
            .getSingleResult();
    return results;
}

@GET
@Path("{id}")
@Produces(MediaType.TEXT_HTML)
public void findId(@PathParam("id") Integer id,
        @Context final HttpServletRequest request,
        @Context final HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AMLManagement.jsp");
    request.setAttribute("items", find(id));
    dispatcher.forward(request, response);
}