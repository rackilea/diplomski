@Entity
@Table(name = "files_info")
public class FileInfo {
}

@Entity
@Table(name = files_versions)
public class FileVersion {
    ... //some attributes
    @Column(name = "version")
    private int version;

    @ManyToOne
    @JoinColumn(name = "file_id")
    private FileInfo fileInfo;

    ... //some getters and setters

    @PrePersist
    private void setupVersion() {
        // fileInfo should be set before of calling persist()!
        // fileInfo should increase its lastest Version before of calling persist()!
        this.version = this.fileInfo.getLastVersion();
    }
}