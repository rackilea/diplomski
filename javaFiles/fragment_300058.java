@GET
@Produces("text/html")
@Path("{page}") 
public void showJSP(@Context HttpServletResponse response,
                    @Context HttpServletRequest request,
                    @PathParam("orderId") String orderId) throws ServletException, IOException {
    request.getRequestDispatcher(page + ".jsp").forward(request, response);
}