URL url = new URL(myurl);
 URLConnection connection = null;
 PrintWriter out = null; BufferedReader br = null; connection = url.openConnection(); connection.setDoOutput(true);
 out = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()),true);
 while(iterations)
     { 
//print data on writer 
out.println(object);
 } 
//closig print writer
 out.flush(); 

//Response from server
 br = new BufferedReader(new InputStreamReader(connection.getInputStream())); // Get Exception in //this line EOF Exception
 String temp;
 while(temp = br.readLine() !=null)
{ //do something }
 out.close();