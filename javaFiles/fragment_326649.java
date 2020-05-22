public void doRemoval(String filename)
{
    contents = new Vector();
    inputstream = new FileInputStream(filename);
    br = new BufferedReader(new InputStreamReader(inputstream));
    String string = "";
    while((string = br.readLine())!= null)
    {
        String[] split = string.split(",");
        Vector vector = new Vector();
        for(int i=0; i<split.length; i++)
            vector.add(split[i].trim());
        if(!vector.contains("?"))
        {
            contents.add(split);
        }

    }