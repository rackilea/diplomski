public boolean equals(Name otherName)
{
    return (otherName.getFirst().equalsIgnoreCase(Name.getFirst()) 
            && otherName.getMiddle().equalsIgnoreCase(Name.getMiddle())
            && otherName.getLast().equalsIgnoreCase(Name.getLast()));
}