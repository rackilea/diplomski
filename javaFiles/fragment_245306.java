@GET
@Path("/{id}")
@UnitOfWork
public Company getById(@PathParam("id") LongParam id) {
    return companyDAO.findById(id.get()).get();
}