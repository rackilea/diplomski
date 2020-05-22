for (File File1:F) 
{
    FileInputStream fstream = null;
    String strLine;
    StringBuilder sb= new StringBuilder();
    try 
    {
        fstream = new FileInputStream(File1);
         BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        while ((strLine = br.readLine()) != null)   
        {
            System.out.println (strLine);
            sb.append(str);
        }
        final TextArea txt=new TextArea(sb.toString());

        layout.addComponents(txt); 
        //br.close();
    }
    catch (IOException e) 
    {
        e.printStackTrace();
    }
}