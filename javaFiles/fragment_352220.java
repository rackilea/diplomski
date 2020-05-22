@XmlRootElement(name = "xmlUser")
class UserWrapper {

    private User user;

    public UserWrapper() {
    }

    public UserWrapper(User user) {
        this.user = user;
    }

    @XmlAttribute(name = "name")
    public String getUserName() {
        return user.getUserName();
    }

    @XmlElement(name = "surname")
    public String getUserSurname() {
        return user.getUserSurname();
    }

}