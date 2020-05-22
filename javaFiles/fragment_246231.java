@GET
@Path("/get1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public Status getstudent(
        @FormParam("title") String title,
        @FormParam("singer") String sing) {
    System.out.println("GET1 title = " + title);
    System.out.println("GET1 singer = " + singer);
    Status status = new Status();
    status.setStatus_flag("success");
    return status;
}