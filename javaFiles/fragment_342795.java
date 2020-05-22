public static final void foo(URL url, String file){
  BufferedReader in;
  String readLine;
  try{
    InputStreamReader isr = new InputStreamReader(url.openStream());
    String encoding = isr.getEncoding(); //if you actually need it, which I don't suppose
    in = new BufferedReader(isr);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(file) , encoding));
    while ((readLine = in.readLine()) != null) {
      System.out.println(readLine+"\n");
      out.write(readLine+"\n");
    }
    out.flush();
    out.close();
  }
}