public class CasterImpl<T> implements Caster<T> {

    private Clazz<T> clazz;

    public CasterImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    public boolean tryCast(Object value){
        try{
            clazz.cast(value);
            return true;
        } catch (ClassCastException e){
            return false;
        }
   }
}