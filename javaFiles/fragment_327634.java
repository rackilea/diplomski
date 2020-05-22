for(int row = 0; row < courseCode.length; row++) {
  System.out.println("\nResult Semester " + (row + 1));
  System.out.println("Course Code\t Course Name\t Credit Hour\t Marks\n");    
  for(int col = 0; col < courseCode[row].length; col++) {
      System.out.print(courseCode[row][col] + "\t");
      System.out.print(sbjName[row][col] + "\t");
      System.out.print(CHour[row][col] + "\t");
      System.out.print(Marks[row][col] + "\t");                      
      System.out.print("\n");
  }
}