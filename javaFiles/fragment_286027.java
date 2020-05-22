Map <Integer, List <String>> map = new HashMap <>();

// Initialize the map
map.put(1, new ArrayList <String> ());
map.put(2, new ArrayList <String> ());
map.put(3, new ArrayList <String> ());
map.put(4, new ArrayList <String> ());

String str = "[:ordername:ordertime:orderprice:orderquantity:]," + 
             "[:ordername2:ordertime2:orderprice2:orderquantity2:]";

// loop through each order set
for (String s: str.split(","))
{
    // remove any leading and trailing spaces
    s = s.trim();

    // remove the brackets 
    s = s.replaceAll("[\\[\\]]", "");

    int i = 1;

    // loop through each order component
    for (String c: s.split(":"))
    {
        // remove any leading and trailing spaces
        c = c.trim();
        if (c.length() > 0)
        {
            map.get(i).add(c);
            i++;
        }
    }
}

System.out.println(map);