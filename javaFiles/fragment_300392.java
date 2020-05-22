try
{
    File file = new File("abc.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));
    String word2 = br.readLine();
    br.close();
    //test:
    System.out.println(word2);
} catch (IOException e)
{
    // Something went wrong, eg: file not found
    e.printStackTrace();
}