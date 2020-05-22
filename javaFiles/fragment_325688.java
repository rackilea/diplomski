String path = "C:\\Program Files";

URL url = new File(path).toURI().toURL();
System.out.println(url);            // prints file:/C:/Program%20Files
System.out.println(url.getPath());  // prints /C:/Program%20Files

File file = new File(url.getPath());
System.out.println(file.exists());  // prints false, because
                                    // "Program%20Files" ≠ "Program Files"