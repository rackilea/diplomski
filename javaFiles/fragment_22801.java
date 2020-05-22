try(FileInputStream in = new FileInputStream(accountFile);
    BufferedReader rdr = new BufferedReader(new InputStreamReader(in))
   )
{
    String in = rdr.readLine();
}