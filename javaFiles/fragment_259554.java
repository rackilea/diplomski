public class BeanPropertyRowMapper<T> implements RowMapper<T> {

     private Class<T> mappedClass;

     public BeanPropertyRowMapper(Class<T> mappedClass) {
        initialize(mappedClass);
    }

}