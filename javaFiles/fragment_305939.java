InputStream response = connection.getInputStream();
        BufferedReader br = new BufferedReader(new     
InputStreamReader(response));
String str="", temp;
while (null != ((temp = br.readLine())))
{
    System.out.println (str);
    str=str + temp;             
}