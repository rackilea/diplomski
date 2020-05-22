static final long SIGN = 0x8000000000000000L;
static final long EXPN = 0x7ff0000000000000L;
static final long SGNF = 0x000fffffffffffffL;

public static void main(String[] args){
    Double d = -0.0000000000015;//1500000000000d;
    long lng = Double.doubleToLongBits(d);
    String bin = Long.toBinaryString(lng);
    long sign = (lng & SIGN) >>> (bin.length()-1);
    long expn = (lng & EXPN) >>> 52;
    long sgnf = lng & SGNF;



    System.out.println("sign-bin: "+Long.toBinaryString(sign));
    System.out.println("expn-bin: "+Long.toBinaryString(expn));
    System.out.println("sgnf-bin: "+Long.toBinaryString(sgnf));
    System.out.println("sign-string: "+Long.toString(sign));
    System.out.println("expn-string: "+Long.toString(expn));
    System.out.println("sgnf-string: "+Long.toString(sgnf));

    String mantisse = Long.toBinaryString(sgnf);
    int pow2 = 2;
    double fraction = 0;
    for(int i = 0; i < mantisse.length(); i++){
        if(mantisse.charAt(i) == '1'){
            double curr = 1.0/pow2;
            fraction += Double.isInfinite(curr)? 0: curr;
        }
        //System.out.println(fraction + " " + pow2);
        pow2 <<= 1;
    }

    System.out.println((1+fraction));
    System.out.println("Back to decimal: " + (sign == 1?(-1):1) * (1+fraction) * Math.pow(2, expn - 1023));
}