public static final class UserResponseWithConverter {
    public String name;
    @JsonProperty("results")
    @JsonDeserialize(converter = ConvertResultsToUserList.class)
    public List<User> users;

    public static final class Results {
        public int count;
        public List<User> users;
    }

    public static final class User {
        public String username;
        public int age;
    }

    public static final class ConvertResultsToUserList extends StdConverter<Results, List<User>> {
        @Override
        public List<User> convert(Results value) {
            return value.users;
        }
    }
}