import java.io.Serializable;

public class Group implements Serializable
{
/**
 * 
 */
private static final long serialVersionUID = 1L;

private String guid;
private String groupName;

public Group(String guid, String groupName) {
    super();
    this.guid = guid;
    this.groupName = groupName;
}

public String getGuid() {
    return guid;
}
public void setGuid(String guid) {
    this.guid = guid;
}
public String getGroupName() {
    return groupName;
}
public void setGroupName(String groupName) {
    this.groupName = groupName;
}
}