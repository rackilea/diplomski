import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class updateEntityListener{
    private String preUpdate = "";
    private String postUpdate = "";

    @PostPersist
    public void postPersist(final ExampleTable ex) {
//Insert data in another table
ex.setAuditInfo(new Object()); //Actual object instead of new Object()
        System.out.println("Row inserted");
    }

    @PostUpdate
    public void postUpdate(final ExampleTable ex) {
        postUpdate = ex.toString();
        if (!preUpdate.equals(postUpdate)) {
            System.out.println("Row Updated");
            // Insert in new table, compare from postLoad
            ex.setAuditInfo(new Object()); 
        }
    }
    @PostLoad
    public void postLoad(final ExampleTable ex) {
        preUpdate = ex.toString();
    }
}