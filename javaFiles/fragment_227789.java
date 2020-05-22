@GET
@Path("/{accountId}")
public Response getAccount(@PathParam("accountId") Integer accountId) {
    Account account = accountDao.getAccount(accountId);
    account.setUsers(userDao.getUsersForAccount(accountId));
    return Response.ok(account).build();
}