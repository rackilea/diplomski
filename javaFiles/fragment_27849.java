import org.sonar.api.database.DatabaseSession;
import org.sonar.api.database.configuration.Property;
import org.sonar.api.resources.Project;
import org.sonar.api.resources.Resource;

public class PropertyPersister{

    private DatabaseSession session;
    private Project project;
    private Property newProperty;

    public PropertyPersister (DatabaseSession session, Project project){
    this.session = session;
    this.project = project; 
    }

    private void persistProperty (Resource resource) {
        int resourceId= resource.getId();       
        newProperty = new Property("sonar.myFabulousProperty", "someValue", resourceId);
        session.save(newProperty);      
    }
}