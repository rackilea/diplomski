try
{
    String hex = "AAA"
    int value = Integer.parseInt(hex, 16);  
    System.out.println("valid hex);
 }
 catch(NumberFormatException nfe)
 {
    // not a valid hex
    System.out.println("not a valid hex);
 }