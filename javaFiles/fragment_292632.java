class ObjectClass implements Serializable {
 String name;
 String number;
 //constructor , setters , getters  and w.e functions .

public static void main (String args[]){
try{    
 ObjectClass test = new ObjectClass("test",2);
 File f = new File("path to file");
 ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
 out.writeObject(test); // this will write the object as it is onto the file
 out.close();
}catch(Exception ex){}

    }

 }