static <T> UnaryOperator<T> identity() {
    return new UnaryOperator<T>{
       public T apply(T parameter){
         return parameter;
       }
    }
}