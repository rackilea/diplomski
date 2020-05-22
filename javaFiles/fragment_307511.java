public void run() {
            for (int n = 1; n < 9999; n++) 
{           spd=1;                                                         
                for (int d = 2; d <= n/2; d++) { //no need to go further than n/2
                    //d is the potential divisor of n, ranging from 2 to n-1,// 
                if(n%d==0) spd+=d; //if n divides by d add it to spd.

            }
            if(spd==n) print(n);
        }