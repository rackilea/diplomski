public class MyDTO<T> {  
    private MyWrapperClass wrapper;  

    public MyDTO(Object[] fields, WrapperFactory<T> wrapperFactory) {
        T data = (T) fields[0];        
        wrapper = wrapperFactory.newWrapper(data);
    }
}