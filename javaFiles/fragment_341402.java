BufferedWriter bw = new BufferedWriter(new FileWriter(file));
String title = "New Page";
String body = "<body><p>This is Body</p></body>";
bw.write("<html><head><title>");
bw.write(title);
bw.write("</title></head>");
bw.write(body);
bw.write("</title></head></html>");
bw.close();