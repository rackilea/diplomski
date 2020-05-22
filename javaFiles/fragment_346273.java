public interface BodyBehaviour {
    String getType ();
    Double getLuminosity (Body body);
    // anything else you need that's type specific....
}

public class PlanetBodyBehavior implements BodyBehaviour {
    public static final String TYPE = "Planet"
    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public Double getLuminosity(Body body) {
        // planet specific luminosity calculation - probably 0 
        return calculatedLuminosity;
    }
}