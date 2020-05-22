@POST
@Path("/usuarios")
public Response save(Usuario user) {
    try {
        manager= new AccessManager();
        manager.save(user);
        return Response.ok("User has been created.").build();
    } catch (Exception e) {
            e.printStackTrace();
    }
    return usuarios;
}

@DELETE
@Path("/usuarios/{id}")
public Response delete(@PathParam("id") String id) {
    try {
        manager= new AccessManager();
        manager.delete(id);
        return Response.ok("User has been deleted.").build();
    } catch (Exception e) {
            e.printStackTrace();
    }
    return usuarios;
}

@PUT
@Path("/usuarios/{id}")
public Response delete(@PathParam("id") String id, Usuario user) {
    try {
        manager= new AccessManager();
        manager.update(id, user);
        return Response.ok("User has been updated.").build();
    } catch (Exception e) {
            e.printStackTrace();
    }
    return usuarios;
}