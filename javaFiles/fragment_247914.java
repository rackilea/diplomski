public static void doIt(BufferedReader r, PrintWriter w) throws IOException
{
    List<String> listStrings = new ArrayList<>();
    String line;
    while((line = r.readLine()) != null)
    {
        listStrings.add(line);
    }

    Collections.sort(listStrings, String.CASE_INSENSITIVE_ORDER.reversed());

    for(String text : listStrings)
    {
        w.println(text);
    }
    w.flush();
}