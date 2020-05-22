Custom c1 = setResponseValue( Custom::new, "a1" );        
Custom1 c2 = setResponseValue(  Custom1::new, "a1" );

public static <T extends Response> T setResponseValue(Supplier<T> s, String value){
    T result = s.get();
    result.setA(value);
    return result;
}