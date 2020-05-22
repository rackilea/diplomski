public static double divisible(String hash, int mod) 
{
    int val = 0;        
    int o = hash.length() % 4;      
    int i = 0;

    if(o > 0) {i = o - 4;}
    if(o < 0) {i = 0;}

    for (; i < hash.length(); i += 4) 
    {           
       val = ((val << 16) + Integer.parseInt(hash.substring(i, i+4), 16)) % mod;            
    }
    return val;
 }