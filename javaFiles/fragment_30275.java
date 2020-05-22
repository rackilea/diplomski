String ip = 85.64.225.159;
int caching1 = IP2Country.NO_CACHE;  // Straight on file, Fastest startup, slowest queries
int caching2 = IP2Country.MEMORY_MAPPED; // Memory mapped file, fast startup, fast queries.
int caching3 = IP2Country.MEMORY_CACHE; // load file into memory, slowerst startup, fastest queries
IP2Country ip2c = new IP2Country(caching1);
Country c = ip2c.getCountry(ip);
if (c == null)
{
        System.out.println("UNKNOWN");                          
}
else
{
        // will output IL ISR ISRAEL
        System.out.println(c.get2cStr() + " " + c.get3cStr() + " " + c.getName());      
}