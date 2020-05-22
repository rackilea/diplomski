String s = "IPOD6 1 USD6IPHONE6 16G,64G,128G USD9,USD99,USD999MACAIR 2013-2014 USD123MACPRO 2013-2014,2014-2015 USD899,USD999";
String[] parts = s.split("(?<=\\bUSD\\d{1,99}+\\B)");
for(String i: parts)
{
    System.out.println(i);
}