val first_ten_bytes = managed(new FileInputStream("test.txt")) map { 
   input =>
     val buffer = new Array[Byte](10)
     input.read(buffer)
     buffer
}