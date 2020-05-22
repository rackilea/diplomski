@Path("/users")
public class UserRestService {

    @GET
    public void getAllUsers(@Suspend final AsyncResponse asyncResponse) {
        new Thread(new Runnable(
            @Override
            public void run() {
                List<Users> users = UserDAO.loadAllUsers();
                asyncResponse.resume(users);
            }
        ) {}).start();
    }
}