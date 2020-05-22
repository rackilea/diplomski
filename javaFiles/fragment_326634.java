private Route topLevelRoute() {
 try {
   InputStreamReader inputStreamReader = new InputStreamReader(getClass().getResourceAsStream("/asciidoc/html/api.html"));
   BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
   //Get the stream input into string builder
   reader.lines().forEach(s -> strBuild.append(s));

   inputStreamReader.close();
   bufferedReader.close();
   //pass the string builder as string with contenttype set to html
   complete(HttpEntities.create(ContentTypes.TEXT_HTML_UTF8, strBuild.toString()))
 } catch (Exception ex) {
        //Catch any exception here
 }
}