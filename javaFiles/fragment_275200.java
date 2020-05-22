InputStreamReader reader = new InputStreamReader(
        yourInputStream, "windows-1252"); 
        // or what ever seems to be the correct encoding!

StringBuilder builder = new StringBuilder();

while (reader.ready())
{
    builder.append(reader.read());
}
reader.close();

String string = builder.toString();