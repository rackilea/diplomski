public class MorphiaClient {
  public static void main(String[] args) {
    final Morphia morphia = new Morphia();
    morphia.mapPackage("org.mongodb.morphia");
    final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
    Input input = new Input();
    input.setName("name");
    input.setDate(new Date());
    datastore.save(input);
}