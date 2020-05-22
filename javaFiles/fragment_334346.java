URL url = new URL("http://www.shefinds.com/files/Christian-Louboutin-Décolleté-100-pumps.jpg");
URLConnection connection = url.openConnection();
connection.setRequestProperty("User-Agent", "Mozilla/4.0");
InputStream input = connection.getInputStream();
OutputStream output = new FileOutputStream("/pic.jpg");
for (int data = 0; (data = input.read()) != -1;) {
    output.write(data));
}