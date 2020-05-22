while (in.hasNextLine())
{               
    lines++;    
    String line = in.nextLine();
    for (String word : line.split("\\s")) 
    {
        words++;
    }   
}