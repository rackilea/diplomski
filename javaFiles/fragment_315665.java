public void printSinusoidalPeriod(double a){

    double pi=Math.PI;
    double p=m*pi;

    while(n<a/2){

        if((double)Math.round((n*pi)%pi)!=0.01){

            n=n+1;

            m = (int) Math.round(((2 * (double) n) / a));
            p= (double)Math.round(m * pi * 100) / 100;
            p=p*n;

        }
    }
    System.out.println("period of function is = " + p + " and n = " + n);
    System.out.println("Check: p/n = " + p/n);
}