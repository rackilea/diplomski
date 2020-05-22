PrintWriter out = null;
try {

out = new PrintWriter(new BufferedWriter(new FileWriter("outfilename", 

true)));
    out.println("the text");
} catch (IOException e) {
    e.printStackTrace ();
} 
finally {
  if (out != null) {
     out.close ();
  }
}