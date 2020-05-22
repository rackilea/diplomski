for (String line; (line = reader.readLine()) != null && counter != activecode.length;) 
{
    line = line.replace(activecode[counter], "");
    writer.println(line);
    counter++;
}