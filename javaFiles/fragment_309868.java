String path = "/mnt/sdcard/Album/album3_137213136.jpg";
String album = path.replaceAll(".*(album\\d+)_.*", "$1");
System.out.println(album); // prints "album3"
path = "/mnt/sdcard/Album/album21_137213136.jpg";
album = path.replaceAll(".*(album\\d+)_.*", "$1");
System.out.println(album); // prints "album21"