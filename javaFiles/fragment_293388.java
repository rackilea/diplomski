File myFoo = new File("path/to/history.txt");
FileOutputStream fooStream = new FileOutputStream(myFoo, false); // true to append
                                                                 // false to overwrite.
byte[] myBytes = "".getBytes() 
fooStream.write(myBytes);
fooStream.close();