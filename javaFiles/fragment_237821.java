public static void main(String [] args){
    BigInteger i = new BigInteger("2");
    double sqroot, cuberoot, fifthroot;
    while(true) {
        sqroot = Math.sqrt(i.floatValue());
        cuberoot = Math.cbrt(i.floatValue());
        fifthroot = Math.pow(i.floatValue(),1/5.0d);
        System.out.print("i = "+i);
        if(Math.floor(sqroot)==sqroot && Math.floor(cuberoot)==cuberoot && Math.floor(fifthroot)==fifthroot){
             break;
        }
        i= i.add(new BigInteger("1"));
    }
    System.out.println(i);
}