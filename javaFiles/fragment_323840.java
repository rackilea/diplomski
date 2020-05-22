public class Main {

    private static class UsersResource extends BaseCollectionsResponse<ArrayList<UserResource>> {
        public UsersResource() {
            super("users", new ArrayList<UserResource>());
        }
    }

    private static class UserResource extends BaseSingularResponse {

        private String name;
        private String id = UUID.randomUUID().toString();

        public UserResource(String userName) {
            super("user");
            this.name = userName;
        }

        public String getUserName() {
            return this.name;
        }

        public String getUserId() {
            return this.id;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        UsersResource userCollection = new UsersResource();
        UserResource user1 = new UserResource("John");
        UserResource user2 = new UserResource("Jane");
        UserResource user3 = new UserResource("Martin");

        System.out.println(user1.serialize());

        userCollection.getCollection().add(user1);
        userCollection.getCollection().add(user2);
        userCollection.getCollection().add(user3);

        System.out.println(userCollection.serialize());
    }
}