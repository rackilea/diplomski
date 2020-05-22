import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class MyDetail {
    // ...
    @Persistent
    private String entry;
    // ...