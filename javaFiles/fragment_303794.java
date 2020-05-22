try{
URLConnection conn = url.openConnection();
conn.setConnectTimeout(20);
conn.setReadTimeout(...)

BufferedReader br = new BufferedReader(new 
InputStreamReader(conn.getInputStream()));              
System.out.println("connected"); 

while ((line = br.readLine()) != null)
{
 result += line;
}
} catch (IOException e) {
    ... deal with wrong address, timeout and etc
}