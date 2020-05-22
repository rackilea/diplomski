public class UserBean {

private String name;
private String id;
private boolean hasPhoto;

public UserBean(String name, String id, boolean hasPhoto) {
    super();
    this.name = name;
    this.id = id;
    this.hasPhoto = hasPhoto;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public boolean isHasPhoto() {
    return hasPhoto;
}

public void setHasPhoto(boolean hasPhoto) {
    this.hasPhoto = hasPhoto;
}
}