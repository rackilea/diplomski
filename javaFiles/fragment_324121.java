@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
class User {
    private int userId;
    private String userName;
    private String password;
    private long passwordUpdated;
    private long passwordExpire;
    private String sessionKey;
}

@JsonRootName(value = "users")
class UserList {
    @JacksonXmlProperty(localName = "user")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<User> users = new ArrayList<>();
}