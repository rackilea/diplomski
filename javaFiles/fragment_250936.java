protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
  // Do whatever you want here...
  InputStream is = request.getInputStream();      
  if (is != null) {
    StringBuilder sb = new StringBuilder();
    String line;
    try {
        BufferedReader reader = 
          new BufferedReader(new InputStreamReader(is, "UTF-8"));
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
    } finally {
        is.close();
    }
    System.out.println(sb.toString());
  }
  //...
}