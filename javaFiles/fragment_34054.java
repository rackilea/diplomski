private static String clientId = "FILL-IN-HERE";
 private static String authTokenEndpoint = "FILL-IN-HERE";
 private static String clientKey = "FILL-IN-HERE";

 AccessTokenProvider provider = new ClientCredsTokenProvider(authTokenEndpoint, clientId, clientKey); 
private static String accountFQDN = "FILL-IN-HERE";  // full account FQDN, not just the account name
ADLStoreClient client = ADLStoreClient.createClient(accountFQDN, provider);

try {
String filename = "/a/b/c.txt";
OutputStream stream = client.createFile(filename, IfExists.OVERWRITE  );
PrintStream out = new PrintStream(stream);
for (int i = 1; i <= 10; i++) {
    out.println("This is line #" + i);
    out.format("This is the same line (%d), but using formatted output. %n", i);
}
out.close();
System.out.println("File created.");

}catch(Exception ex){
 System.out.format(" Exception: %s%n Message: %s%n", ex.getClass().getName(), ex.getMessage());
}