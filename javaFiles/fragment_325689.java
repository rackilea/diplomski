String path = "C:\\Users\\VGR\\Documents\\résumé.txt";

URL url = new File(path).toURI().toURL();

// Prints file:/C:/Users/VGR/Documents/r%C3%A9sum%C3%A9.txt
System.out.println(url);

// Prints /C:/Users/VGR/Documents/r%C3%A9sum%C3%A9.txt
System.out.println(url.getPath());

File file = new File(url.getPath());
System.out.println(file.exists());  // prints false, because
                                    // "r%C3%A9sum%C3%A9.txt" ≠ "résumé.txt"