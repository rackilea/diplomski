@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "code")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Result.Error.class, name = "KO"),
        @JsonSubTypes.Type(value = User.class, name = "<your string to determine whether the message is a user or not>") })
static class Result {
    String code;

    Message message;

    interface Message {
        int id();
        // other common properties...
    }

    static class Error implements Message {

        @Override
        public int id() {
            return -1;
        }
    }

    static class User implements Message {

        public int id;
        public String name;

        // other fields...

        @Override
        public int id() {
            return id;
        }
    }

}