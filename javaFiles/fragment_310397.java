public static <T> T deNull(T value, T orElse){
    if(value == null ){
        return orElse;
    } else {
        return value;
    }
}   

String x = deNull( string, "");
Integer y = deNull( integer, 0);