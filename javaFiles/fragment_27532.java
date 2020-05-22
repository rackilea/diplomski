// Copy input into output.
for(input <- managed(new java.io.FileInputStream("test.txt"); 
    output <- managed(new java.io.FileOutputStream("test2.txt")) {
  val buffer = new Array[Byte](512)
  while(input.read(buffer) != -1) {
    output.write(buffer);
  }
}