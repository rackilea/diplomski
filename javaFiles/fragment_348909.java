public class Main 
{
    public static void main(String args[])
    {
        new Main().run();
    }

    private void run()
    {
        List<Domain> domains = getDomains();

        System.out.println("Domains before sorting: " + domains);

        List<Domain> sortedDomains1 = sortDomains1(new ArrayList<Domain>(domains));
        List<Domain> sortedDomains2 = sortDomains2(new ArrayList<Domain>(domains));

        System.out.println("Domains after sorting by method1: " + sortedDomains1);
        System.out.println("Domains after sorting by method2: " + sortedDomains2);

        System.out.println("Original list: " + domains);
    }

    private List<Domain> sortDomains1(final List<Domain> domains)
    {
        List<Domain> tempList = null;
        int i = 0;
        for(final Domain domain : domains) 
        {
            if(domain.getName().equalsIgnoreCase("Hilton")) 
            {
                tempList = domains.subList(i, i+2);
                break;
            }
            i++;
        }

        Domain tempDomain;
        tempDomain = tempList.get(1);
        tempList.set(1, tempList.get(0));
        tempList.set(0, tempDomain);

        return domains;
    }

    private List<Domain> sortDomains2(final List<Domain> domains)
    {
        for(int i = 0; i < domains.size(); i++) 
        {
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

    private class Domain
    {
        private final String name;

        private Domain(final String name)
        {
            this.name = name;
        }

        private String getName()
        {
            return name;
        }

        @Override
        public String toString()
        {
            return name;
        }
    }

    private List<Domain> getDomains()
    {
        List<Domain> list = new ArrayList<Domain>();
        list.add(new Domain("Apple"));
        list.add(new Domain("Bing"));
        list.add(new Domain("Google"));
        list.add(new Domain("Hilton"));
        list.add(new Domain("Ink"));
        list.add(new Domain("Facebook"));
        return list;
    }
}