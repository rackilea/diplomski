FileOutputStream out = new FileOutputStream("myfile.txt");
// Create the stream to the file you want to write too.
ObjectOutputStream objOut = new ObjectOutputStream(out);
// Use the FileOutputStream as the constructor argument for your object.

objOut.writeObject(new Shoe("Prada"));
// Write your object to the output stream.
objOut.close();
// MAKE SURE YOU CLOSE to avoid memory leaks, and make sure it actually writes.