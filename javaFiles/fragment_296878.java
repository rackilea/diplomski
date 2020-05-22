public class Student implements Serializable {

 }

 FileOutputStream fos = new FileOutputStream("Students.dat");
 ObjectOutputStream oos = new ObjectOutputStream(fos);

 Student someStudent = new Student();

 oos.writeObject(someStudent);

 oos.close();