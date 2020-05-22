// get filename
String fileName = "C:\\tmp\\Q37545784.txt";

// get executable of wordpad
String wordPadExecutable = "C:\\Program Files (x86)\\Windows NT\\Accessories\\wordpad.exe";

// create a process builder that executes wordpad and passes filename as parameter
ProcessBuilder pb = new ProcessBuilder(wordPadExecutable, fileName);

// start
pb.start();