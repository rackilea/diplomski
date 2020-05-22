public class Body {
    private Double mass;

    // coordinates,radius and other state variables

    private BodyBehavior bodyBehaviour;

    public void setBodyBehaviour (BodyBehaviour behaviour) {
        this.bodyBehaviour = behaviour;
    }

    public String getBodyType () {
        bodyBehaviour.getType();
    }

    public Double getLuminosity () {
        bodyBehavior.getLuminosity(this);
    }
}