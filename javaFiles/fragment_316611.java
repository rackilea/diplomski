public abstract class ModelWrapper{

    private ModelInstance model;
    private Vector3 position;
    private Quaternion rotation;

    public ModelWrapper(ModelInstance model,Vector3 position,Quaternion rotation) {
        this.model = model;
        this.position = position;
        this.rotation = rotation;
    }

    public ModelInstance getModel() {
        return model;
    }

    public void setModel(ModelInstance model) {
        this.model = model;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Quaternion getRotation() {
        return rotation;
    }

    public void setRotation(Quaternion rotation) {
        this.rotation = rotation;
    }

    public void render(ModelBatch modelBatch, Environment  environment) {
        this.model.transform.set(this.position,this.rotation);
        modelBatch.render(model, environment);
    }
}