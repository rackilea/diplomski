private List<Domain> sortDomains2(final List<Domain> domains, final String elementToMove)
{
    for(int i = 0; i < domains.size(); i++) 
    {
        if(domains.get(i).getName().equalsIgnoreCase(elementToMove)) 
        {
            Domain temp = domains.get(i);
            domains.set(i, domains.get(i+1));
            domains.set(i+1, temp);
            i++;
        }
    }

    return domains;
}