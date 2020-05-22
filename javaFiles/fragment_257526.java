package example;

import org.restlet.data.MediaType;
import org.restlet.representation.EmptyRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ServerResource;

public class UserResource extends ServerResource {

    @Override
    public Representation get() {
        ExampleApp app = (ExampleApp) getApplication();
        if (!app.authenticate(getRequest(), getResponse())) {
            // Not authenticated
            return new EmptyRepresentation();
        }

        // Generate list of users
        // ...
    }     

    @Override
    public Representation post(Representation entity) {
        // Handle post
        // ...
    }

}