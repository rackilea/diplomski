try {

   ArrayList<NewStudent> student = new ArrayList<>(); 
   BufferedReader inFile = new BufferedReader (new FileReader("Test.txt"));
   String inputLine;

   while ((inputLine = inFile.readLine())!=null) { 

      if(inputLine.isEmpty()) continue; //i dont know if you have blank lines between students in txt, if so. use this line of code.

      NewStudent ns = new NewStudent();
      String[] studentVars = inputLine.split(":"); 
      ns.setId(studentVars[0]);
      ns.setName(studentVars[1]);
      ns.setProgram(studentVars[2]);

      System.out.println("ID: " + studentVars[0] + " Name: " + studentVars[1] + " Program: " + studentVars[2])

      student.add(ns);
}
   //or you could use this to loop and print all items in Arraylist.
   for(NewStudent nStudent : student) {
      System.out.println(nStudent.getId() + " " + nStudent.getName() + " " + nStudent.getProgram());
   }
} catch (FileNotFoundException e) {
   e.printStackTrace();
}