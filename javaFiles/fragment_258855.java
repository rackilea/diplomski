public static final class UserResponse {
    public String name;
    public Results results;

    public static final class Results {
        public int count;
        public List<User> users;
    }

    public static final class User {
        public String username;
        public int age;
    }
}

@Test
public void reads_single_result() throws Exception {
    ObjectReader reader = new ObjectMapper().reader(UserResponse.class)
            .with(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            .with(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES).with(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
    UserResponse response = reader.readValue("{ name: 'API name', results: { count: 1,"
            + " users: { username: 'username', age: 15 } } }");
    assertThat(response.results.users, iterableWithSize(1));
    assertThat(response.results.users.get(0).username, equalTo("username"));
}

@Test
public void reads_two_results() throws Exception {
    ObjectReader reader = new ObjectMapper().reader(UserResponse.class)
            .with(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            .with(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES).with(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
    UserResponse response = reader.readValue("{ name: 'API name', results: { count: 2,"
            + " users: [{ username: 'username1', age: 18 }, { username: 'username2', age: 19 }] } }");
    assertThat(response.results.users, iterableWithSize(2));
    assertThat(response.results.users.get(0).username, equalTo("username1"));
    assertThat(response.results.users.get(1).username, equalTo("username2"));
}