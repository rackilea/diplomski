public string ReadField(BufferedReader reader) 
{
    string line = reader.readLine();
    while (line.indexOf("</#FIELD>") == -1)
    {
        line += reader.readLine(); // This does not preserve line breaks
    }

    return line;
}