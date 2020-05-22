java> String uri = "file:/sdcard/MyFolder/MyFile.txt";
java> import java.net.*
java> URI urr = new URI(uri);
java.net.URI urr = file:/sdcard/MyFolder/MyFile.txt
java> urr.getScheme();
java.lang.String res2 = "file"
java> urr.getPath();
java.lang.String res3 = "/sdcard/MyFolder/MyFile.txt"