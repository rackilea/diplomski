BufferedReader outReader = new BufferedReader(
                              new InputStreamReader(cmdProc.getInputStream()));
String l;
while ((l= outReader.readLine()) != null) {
   // process standard output here
}