boolean fileExists = false;
File newFile;
while(!fileExists) {
  System.out.println("Enter the name of the file you want to open: ");
  FileN = scan.nextLine();
  newFile = new File(FileN);
  fileExists = newFile.exists();
  if (!fileExists) {
    System.out.println(FileN + " not found...");
  }
}
try {
    Scanner scan;
    scan = new Scanner(newFile);
    ... do stuff with the scanner
}
catch(FileNotFoundException fnfe) {
  System.out.println("sorry but the file doesn't seem to exist");
}