public class KryoTest {
    public static void main(String[] args){

        Vector3d someObject=new Vector3d(1,2,3);

        //serialise object

        //try-with-resources used to autoclose resources
        try (Output output = new Output(new FileOutputStream("KryoTest.ser"))) {
            Kryo kryo=new Kryo();
            kryo.writeClassAndObject(output, someObject);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KryTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //deserialise object

        Vector3d retrievedObject=null;

        try (Input input = new Input( new FileInputStream("KryoTest.ser"))){
            Kryo kryo=new Kryo();
            retrievedObject=(Vector3d)kryo.readClassAndObject(input);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KryTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Retrieved from file: " + retrievedObject.toString());
    }
}