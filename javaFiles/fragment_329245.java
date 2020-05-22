public static void main(String[] args)
        throws IOException
{
    URL url = new URL("http://stackoverflow.com/");
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

    String s = null;
    while ((s = reader.readLine()) != null)
        System.out.println(s);
}