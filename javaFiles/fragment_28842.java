int x = 999999;
int $ = 0;
int exp = 0;
while (x > 0) { 
    int t = ((x % 10) +2) %10;
    $ += Math.pow(10, exp++) *t;
    x /= 10;
}
System.out.println($);