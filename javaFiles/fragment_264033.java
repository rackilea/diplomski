File file2 = new File  ("c:\\myclasses\\");

// Convert File to a URL
URL url = file2.toURL();          // file:/c:/myclasses/
 URL[] urls = new URL[]{url};

// Create a new class loader with the directory
ClassLoader cl = new URLClassLoader(urls);

 // Load in the class; 
 Class cls = cl.loadClass("test.MyClass");