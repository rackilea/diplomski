try 
{
    FileWriter fw = new FileWriter("test.txt");
            BufferedWriter out = new BufferedWriter(fw);
            out.write("aString");
} 
catch (IOException e) 
{
    e.printStackTrace();
}