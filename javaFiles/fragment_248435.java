...
// command line parameter
if(argv.length != 1) {
  System.err.println("Invalid command line, exactly one argument required");
  System.exit(1);
}

try {
  FileInputStream fstream = new FileInputStream(argv[0]);
} catch (FileNotFoundException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
}

// Get the object of DataInputStream
...

> java -cp ... Zip \path\to\test.file