URL url;
InputStream is = null;
DataInputStream dis;
String line;
url = new URL([put a string with the local host address here. Usual is something like 127.0.0.1]); // can also just put a website to test it.
is = url.openStream();  // throws an IOException
dis = new DataInputStream(new BufferedInputStream(is));

while ((line = dis.readLine()) != null) {
    System.out.println(line); //will get each line from the text file and print it. could also put it in a variable.
}