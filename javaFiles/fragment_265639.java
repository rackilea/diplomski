ArrayList<Student> list = new ArrayList<Student>();
list.add(student1);
list.add(student2);
list.add(student3);

FileOutputStream fos;
try 
{
   fos = new FileOutputStream(FILENAME);
   ObjectOutputStream oos = new ObjectOutputStream(fos);
   oos.writeObject(list);
   // read back
   FileInputStream fis = new FileInputStream(FILENAME);
   ObjectInputStream ois = new ObjectInputStream(fis);
   Object obj = ois.readObject();
   ArrayList<Student> listFromFile = (ArrayList) obj;
   for (Student student: listFromFile) 
   {
     System.out.println(student.toString());
   }     
} 
catch (FileNotFoundException e) 
{
  e.printStackTrace();           
}