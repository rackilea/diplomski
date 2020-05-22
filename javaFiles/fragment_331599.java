@Override
public void countNameStarByt(ArrayList<Teacher> lst) {
   int count = 0;
   for (Teacher teacher: lst) {
      if(teacher.getName().startsWith("T")){
        count++;
        teacher.show();
      } 
   }
   if (count == 0) {
      System.out.println("No teacher has name starting with letter 'T'.");
   }
}