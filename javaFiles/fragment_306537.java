@GET
@Path("authentifier/{numerocompte}/{mdp}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Client authentifier(@PathParam("numerocompte") int numerocompte, 
                           @PathParam("mdp") String mdp) {

    ClientDao dao = new ClientDao();
    System.out.println(numerocompte);
    return dao.authentifier(numerocompte,mdp);
}