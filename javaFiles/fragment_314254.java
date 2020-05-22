BufferedReader file = new BufferedReader(new FileReader("myFile.html"));
String line;
StringBuffer buffer = new StringBuffer();
while (line = file.readLine()) {
 buffer.append(line);
 buffer.append('\n');
    }
    String input = buffer.toString();

    file.close();
input = input.replace("What I want to insert into", "What I (hi there) want to insert into");

FileOutputStream out = new FileOutputStream("myFile.html");
out.write(inputStr.getBytes());
out.close();