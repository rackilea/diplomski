@Entity
public class Files implements Serializable {

    @ManyToMany
    public Set<Tags> getUserTags() {
        return userTags;
    }

    @ManyToMany
    @ForeignKey(name = "AUTO_FILES_TAGS", inverseName = "AUTO_TAGS_FILES")
    @JoinTable(name = "AUTOTAGS_FILES", joinColumns = @JoinColumn(name = "FILES_ID"), inverseJoinColumns = @JoinColumn(name = "TAGS_ID"))
    public Set<Tags> getAutoTags() {
        return autoTags;
    }

    // ...
}