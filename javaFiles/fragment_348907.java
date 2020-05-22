private List<Domain> sortDomains2(final List<Domain> domains)
{
    for(int i = 0; i < domains.size(); i++) {
        if(domains.get(i).getName().equalsIgnoreCase("Hilton")) 
        {
            Domain temp = domains.get(i);
            domains.set(i, domains.get(i+1));
            domains.set(i+1, temp);
            i++;
        }
    }

    return domains;
}