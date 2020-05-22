public static void main (String[] args){
  Grade[] grades = {new Grade("A", 95), new Grade("A-", 90)}; //Add more

  for (int i = 0; i < grades.length; i++)
     System.out.println (grades[i].grade + "\t" + grades[i].cutoff);
  }