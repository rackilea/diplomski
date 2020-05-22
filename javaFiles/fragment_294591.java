File file = new File("person.txt");
boolean toWrite = false;
boolean toModify = false;
if (file.exists())
{
   if (file.length() == 0)
   {
     toWrite = true;
   }
   else 
   {
     toModify = true;
   }
}
if (toWrite || !file.exists())
{
     FileOutputStream fos = new FileOutputStream(file);
     ObjectOutputStream oos = new ObjectOutputStream(fos);
     oos.writeObject(list);
     fos.close();
     oos.close();
}
else if (toModify)
{
   FileInputStream fins = new FileInputStream(file);
   ObjectInputStream oins = new ObjectInputStream(fins);
   LinkedList<Person> temp = (LinkedList<Person>)oins.readObject();
   fins.close();
   oins.close();
   temp.add(per);
   temp.add(per2);
   temp.add(per3);
   temp.add(per4);
   FileOutputStream fos = new FileOutputStream(file);
   ObjectOutputStream oos = new ObjectOutputStream(fos);
   oos.writeObject(temp);
   fos.close();
   oos.close();
}