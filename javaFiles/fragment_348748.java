void writeExample() throws IOException {
   File f = new File("foo.txt");
   PrintStream out = new PrintStream(
                         new BufferedOutputStream(
                             new FileOutputStream(f)));
   out.println("randomvalue");
   out.println(42);
   out.close();
}

void readExample() throws IOException {
   File f = new File("foo.txt");
   BufferedReader reader = new BufferedReader(new FileReader(f));
   String firstline = reader.readLine();
   String secondline = reader.readLine();
   int answer;
   try {
     answer = Integer.parseInt(secondline);
   } catch(NumberFormatException not_really_an_int) {
     // ...
   }
   // ...

}