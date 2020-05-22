public final class PageInfoKey<T extends BaseView> {
    public static final PageInfoKey<MachineView> MACHINE_VIEWS
            = new PageInfoKey<>("machineViews", MachineView.class);
    /*... more static final keys defined here ...*/

    /* Adding the 'name' and 'type' fields,
     * and equals() and hashCode() as below,
     * allow us to have multiple instances of keys
     * defined elsewhere if desired, which should still
     * work with the lookup.
     *
     * If all keys are defined statically inside this class
     * (i.e. constructor is made private), then these fields
     * and methods are unnecessary.
     */

     private final String name;
     private final Class<T> type;

     public PageInfoKey(String name, Class<T> type) {
         this.name = name;
         this.type = type;
     }

     @Override
     public int hashCode() {
         return Objects.hash(name, type);
     }

     @Override
     public boolean equals(Object other) {
         if(other==this) return true;
         if(other instanceof PageInfoKey) {
             PageInfoKey<?> o = (PageInfoKey<?>)other;
             return Objects.equals(this.name, o.name) &&
                     Objects.equals(this.type, o.type);
         }
         return false;
     }
}

public class PageInfoLookup {

    private final Map<PageInfoKey<?>, List<? extends BaseView>> data = new HashMap<>();

    public <T extends BaseView> void put(PageInfoKey<T> key, List<T> value) {
        data.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseView> List<T> get(PageInfoKey<T> key) {
        return (List<T>) data.get(key);
    }

}