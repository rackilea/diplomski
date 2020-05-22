BufferedReader reader=new BufferedReader(new InputStreamReader(in));

String line=null;
out.write("<?xml version=\"1.0\"?>\r\n");  
out.write("<resources>\r\n");  
while((line=reader.readLine())!=null)
{
  out.write("<item>"+line+"</item>");
}
out.write("</resources>");
out.close();