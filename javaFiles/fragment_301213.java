public class Test {
    static final String filename = "d:/desktop/employee.txt";
    Collection makeColl(){
       return new ArrayList();
    }

    void writeColl(Collection c){ 
        try {
              ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d:/desktop/employee.txt"));
              out.writeObject(c);
              out.close();
          } catch(IOException i){i.printStackTrace();}
    }

    Collection readColl(){
        Object that = null;
        try {
           ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
          that = in.readObject();
        } catch(IOException | ClassNotFoundException i) { i.printStackTrace(); }
        return that;
    }

public static void main(String[] args) {
    Test t = new Test();
    t.writeColl(t.makeColl());
    System.out.println(t.readColl().getClass()); 

  }