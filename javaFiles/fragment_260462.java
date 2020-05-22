public class Temp {
    @Id String _id;

    @Embedded // CHANGE HERE
    List<MapProxy> strings; // CHANGE HERE

    public Temp(){
        strings=new LinkedList<MapProxy>(); // CHANGE HERE
    }

    public static void main(String...args) throws UnknownHostException, MongoException{
        Mongo mongo=null;
        Morphia morphia=null;
        Datastore ds=null;
        mongo = new Mongo();
        morphia = new Morphia();
        morphia.map(Temp.class);
        ds = morphia.createDatastore(mongo, "test2");
        Temp t = new Temp();
        t._id ="hi";      
        MapProxy mp = new MapProxy(); // CHANGE HERE    
        mp.m.put("Hi","1"); // CHANGE HERE
        mp.m.put("Hi2",2); // CHANGE HERE
        t.strings.add(mp); // CHANGE HERE
        ds.save(t);
        t=ds.get(t);
        ds.ensureIndexes();
    }
}