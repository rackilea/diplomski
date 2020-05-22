public static double divisible(String hash, int mod) 
{
    int val = 0;        
    int o = hash.length() % 4;      
    int i = 0;

    if(o > 0) {i = o - 4;}
    if(o < 0) {i = 0;}

    for ( int a = i; a < hash.length(); a += 4) 
    {           
       val = ((val << 16) + Integer.parseInt(hash.substring(a, a+4), 16)) % mod;            
    }
    return val;
 }