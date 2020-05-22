@FunctionalInterface
public interface MyInterface {

    Integer getResult();
    default boolean isNoResult(){
       return getResult()==null;
    }
}