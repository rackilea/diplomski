try {
   URL url = new URL("http://www.puzzlers.org/pub/wordlists/pocket.txt");
   Scanner s = new Scanner(url.openStream());
   // read from your scanner
}
catch(IOException ex) {
   // there was some connection problem, or the file did not exist on the server,
   // or your URL was not in the right format.
   // think about what to do now, and put it here.
   ex.printStackTrace(); // for now, simply output it.
}