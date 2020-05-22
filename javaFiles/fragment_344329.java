HashMap<String, Student> grades = new HashMap<String, Student>();
BufferedReader in = new BufferedReader(new FileReader("grades.txt"));
String line = in.readLine();
while(null != line) {
  String [] columns = line.split(" ");
  grades.put( column[0],
    new Student( /* create student class instance from columns */ );
  line = in.readLine();
}