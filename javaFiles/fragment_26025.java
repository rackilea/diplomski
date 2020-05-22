private void printTxt(String image)
{
    /*
        image variable stores the path to the .txt file
        that contains the ASCII image.
    */
    try
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(image)));

        String line;

        while((line = br.readLine()) != null)
        {
            System.out.println(line);

        }

        br.close();
    }catch(IOException e)
    {
        //handle the exception
    }
}