@Entity
public class Tags implements Serializable {

    @ManyToMany(mappedBy = "userTags")
    @ForeignKey(name = "USER_TAGS_FILES", inverseName = "USER_FILES_TAGS")
    @JoinTable(name = "USERTAGS_FILES", joinColumns = @JoinColumn(name = "TAGS_ID"), inverseJoinColumns = @JoinColumn(name = "FILES_ID"))
    public Set<Files> getUserFiles() {
        return userFiles;
    }

    @ManyToMany(mappedBy = "autoTags")
    public Set<Files> getAutoFiles() {
        return autoFiles;
    }

    //...
}