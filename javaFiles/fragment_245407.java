public static void main(String[] args) {
    final String SYMBOLS_AZ09_ = span('A','Z') + span('0','9') + "_";
    final String SYMBOLS_09AZ = span('0','9') + span('A','Z');
    final String SYMBOLS_AZaz09 = span('A','Z') + span('a','z') + span('0','9');

    BigInteger n = fromString("GFZHFFFZFZTFZTF_24_F34", 37, SYMBOLS_AZ09_);

    // let's convert back to base 37 first...
    System.out.println(toString(n, 37, SYMBOLS_AZ09_));
    // prints "GFZHFFFZFZTFZTF_24_F34"

    // now let's see what it looks like in base 62...       
    System.out.println(toString(n, 62, SYMBOLS_AZaz09));
    // prints "ctJvrR5kII1vdHKvjA4"

    // now let's test with something we're more familiar with...
    System.out.println(fromString("CAFEBABE", 16, SYMBOLS_09AZ));
    // prints "3405691582"

    n = BigInteger.valueOf(3405691582L);
    System.out.println(toString(n, 16, SYMBOLS_09AZ));
    // prints "CAFEBABE"        
}