class User {

        private static User user = null;

        public String firstName = "";

        private User() {}

        public static synchronized User getInstance() {

            if (user == null) user = new User();

            return user;
        }
    }