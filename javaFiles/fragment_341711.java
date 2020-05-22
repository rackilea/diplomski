BufferedReader br = new BufferedReader(new FileReader("file.txt"));

String line;
whlie( (line = br.readLine()) != null ){
   String[] separated = line.split("=");
   if( "uno".equals(separated[0]) )
      // Key is uno seaparated[1] has <editText1 text> (assuming example above)
   if( "dos".equals(separated[0]) )
      // Key is dos separated[1] has <editText2 text> (assuming example above)
   ...
}