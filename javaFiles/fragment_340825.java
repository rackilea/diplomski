@Entity
public class MyEntity {
    @Id
    private Long id;

    @Transient
    private File file;

    private String filePath;

    private String someString;


public void setFilePath(File file) {
    filePath = file.getPath();
}