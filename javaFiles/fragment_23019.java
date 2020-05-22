ModelBatch batch = new ModelBatch();
...
public void render() {

    batch.begin(camera);

    batch.render(instance);
    batch.render(otherInstance, environment);

    batch.end();

}