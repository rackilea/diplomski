final Morphia morphia = new Morphia();

// tell Morphia where to find your classes
// can be called multiple times with different packages or classes
morphia.mapPackage("org.mongodb.morphia.example");

// create the Datastore connecting to the default port on the local host
final Datastore datastore = morphia.createDatastore(new MongoClient(), "morphia_example");
datastore.ensureIndexes();