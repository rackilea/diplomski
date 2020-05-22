class Classroom {
private String classname;
String classroomarray[]=null;//declare  classroomarray[] here 

public String getClassname() {
    return classname;
}

public void setClassname(String classname) {
    this.classname = classname;
}

public void classroomreader(String filename) {

    File text = new File("C:/classlists/" + filename + ".txt");
    Scanner scan;
    try {
        scan = new Scanner(text);
        String line = scan.nextLine();
         classroomarray = line.split("\t");


    } catch (FileNotFoundException e1) {
        e1.printStackTrace();
    }
}