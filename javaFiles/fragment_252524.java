JarFile jar = new JarFile( "path to jar" ); // Opens the jar

Enumerator<JarEntry> es = jar.entries(); //Enumerator to the jar entries

while( es.hasMoreElements() ) { //Iterates until all entries have been visited

  JarEntry entry = es.nextElement(); //Gets the next entry in the jar

  System.out.println(  entry.getName() ); //Prints the entry name

  InputStream in = jar.getInputStream( entry ); //returns an inputstream from the entry
  ... 
}