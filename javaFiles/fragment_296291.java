@SessionScope
    public class LoginService {
        private Client client;

        public void login(String username, String password) {
            //  implement login business

            //  if login is successful
            client = clientEntity;
        }

        @Produces
        @SessionScope
        public Client clientProducer() {
            return this.client;
        }
    }