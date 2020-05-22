@ManagedBean
@ViewScoped
public class Bean {

    private Map<String, List<String>> allImages = new LinkedHashMap<String, List<String>>();
    private List<String> groupNames;
    private String groupName;

    public Bean() {
        allImages.put("group1", Arrays.asList("group1a.jpg", "group1b.jpg", "group1c.jpg"));
        allImages.put("group2", Arrays.asList("group2a.jpg", "group2b.jpg", "group2c.jpg"));
        allImages.put("group3", Arrays.asList("group3a.jpg", "group3b.jpg", "group3c.jpg"));
        groupNames = new ArrayList<String>(allImages.keySet());
    }

    public List<String> getImages() {
        return allImages.get(groupName);
    }

    public List<String> getGroupNames() {
        return groupNames;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}