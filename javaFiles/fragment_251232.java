void migrate(String argument) throws IOException
{
     String[] splitArgument.split(";");

     String post_tran = splitArgument[0];
     String post_tran_cust = splitArgument[1];

     Map<String, Map<String, String>> h1 = loadFile(post_tran, KEY1);
     Map<String, Map<String, String>> h2 = loadFile(post_tran_cust, KEY2);
}