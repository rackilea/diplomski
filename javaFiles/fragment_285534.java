String token1 = "";

// create Scanner inFile1
Scanner inFile1 = new Scanner(new File("YourFilenNme"));

List<String> temps = new LinkedList<String>();


while (inFile1.hasNext()) {
  // find next line
  token1 = inFile1.next();
  temps.add(token1);
}
inFile1.close();

String[] tempsArray = temps.toArray(new String[0]);

Shell.sort(tempsArray);
    show(tempsArray);