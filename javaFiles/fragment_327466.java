CourseListQ2 newList = new CourseListQ2();
BufferedReader inFile = null;
try {
  inFile = new BufferedReader(new FileReader(inputName));
  String nextLine;
  String param1;
  String param1;
  int param3;
  while(null != (nextLine = inFile.readLine())){//read line by line
    param1 = your code here to play with nextLine
    param2 = your code here to play with nextLine
    param3 = your code here to play with nextLine
    newList.addCourse(new Course(param1, param2, param3));
  }
} catch(IOException ex) {
   ex.printStackTrace(System.err);//print exception on console
} finally {//its optional but recommended
  if(null != inFile) {
     try {
        inFile.close();//may cause trouble
     } catch(IOException ex) {
        ex.printStackTrace(System.err);//print exception on console
     }
  }
  return newList;
}