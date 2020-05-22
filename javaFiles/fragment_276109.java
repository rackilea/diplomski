for(i = 0; i < family.length; i++)
{

    if(family[i] != null && family[i].equals(p))
    {
        isPresent = true;
        System.out.println(p.getName() + 
        " is already present in the family");
    }                       
}