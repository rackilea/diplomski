@SessionScope
    public class LoginService {
        @Produces
        @SessionScope
        private Client client;

        public void login(String username, String password) {
            //  implement login business

            //  if login is successful
            client = clientEntity;
        }
    }