// note the arguments for K1, K2. Both extend Number
CompositeKeyImplementer<Integer, Double> cki = 
    new CompositeKeyImplementer<Integer, Double>();
// note the argument for K is Number
CompositeKeyBasedCreditCardDetailsHolder<Number, String> cdh = 
    new CompositeKeyBasedCreditCardDetailsHolder<Number, String>(cki);