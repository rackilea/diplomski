@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
    public class User implements Serializable {

        private UUID userId;

        // -- other fields --

        public User(String userId) {
            this.userId = UUID.fromString(userId);
        }

    }