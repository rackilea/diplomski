while ((line = br.readLine()) != null) 
{
    //be careful! with this, you will add all the lines of
    //the currently processed file to a locally created 
    //StringBuilder object. Is this really what you want?
    text.append(line);
    text.append('\n');

    //here if line contains "test" you can do whatever you want with it.
    if (line.contains("test")) 
    {
        //do something with it
    }
    else
    {
        //no "test" keyword in the current line
    }
}