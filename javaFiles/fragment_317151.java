String getStringRepresentation(ArrayList<Character> list)
{    
    StringBuilder builder = new StringBuilder(list.size());
    for(Character ch: list)
    {
        builder.append(ch);
    }
    return builder.toString();
}