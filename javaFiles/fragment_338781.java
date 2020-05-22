static BigInteger fact(BigInteger bv) {        
    BigInteger fa = BigInteger.ONE;      
    for(BigInteger inte = BigInteger.ONE; inte.compareTo(bv) <= 0; inte = inte.add(BigInteger.ONE)){            
        fa = fa.multiply(inte);
    }        
    return fa;
}