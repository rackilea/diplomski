PrintWriter pw = null;
try {
   File file = new File("C:\\test.txt");
   pw = new PrintWriter(file);
} catch (IOException e) {
   System.out.println("bad things happen");
} finally {
   if (pw != null) {
      try {
         pw.close();
      } catch (IOException e) {
      }
   }
}