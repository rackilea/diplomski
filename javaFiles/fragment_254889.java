File myFoo = new File("foo.log");
FileOutputStream fooStream = new FileOutputStream(myFoo, false); // true to append
                                                                 // false to overwrite.
byte[] myBytes = "New Contents\n".getBytes(); 
fooStream.write(myBytes);
fooStream.close();