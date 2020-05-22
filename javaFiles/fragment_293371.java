BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// or, to read from a file, do:
// BufferedReader br = new BufferedReader(new FileReader("file.txt"));
String line;
while ((line = br.readLine()) != null) {
    String[] a = line.split(",");

    // do whatever you want here
    // assuming the first element in your array is the class name, you can do this:
    Animal animal = Class.forName(a[0]).newInstance();

    // the problem is that that calls the zero arg constructor. But I'll 
    // leave it up to you to figure out how to find the two arg matching
    // constructor and call that instead (hint: Class.getConstructor(Class[] argTypes))
}