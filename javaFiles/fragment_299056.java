// socket is your Java socket object
InputStreamReader charReader = new InputStreamReader(socket.getInputStream());
BufferedReader lineReader = new BufferedReader(charReader);

String line;
ArrayList<String> lines = new ArrayList<String>();

// readLine() reads to the first new line character or end of file
// and returns the string up to that point

while ((line = lineReader.readLine()) != null)
{
    lines.add(line);
}

// Converting to an array of strings is simple Java from here:
String[] arrayOfLines = lines.ToArray(new String[lines.size()]);