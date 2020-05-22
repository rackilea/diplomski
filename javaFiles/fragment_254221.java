@Api(
    name = "books",
    version = "v1",
    namespace = @ApiNamespace(ownerDomain = "backend.example.com", ownerName = "backend.example.com", packagePath = "")
)
public class BooksEndpoint {

    @ApiMethod(name = "saveBook")
    public void saveBook(Book book, User user) throws OAuthRequestException, IOException {
        if (user == null) {
            throw new OAuthRequestException("User is not authorized");
        }

        Account account = AccountService.create().getAccount(user);

        ofy().save()
                .entity(BookRecord.fromBook(account, book))
                .now();
    }

}