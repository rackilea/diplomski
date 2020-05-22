public class ComparatorReflection<T extends AccessibleObject & Member> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        Order or1 = o1.getAnnotation(Order.class); 
        Order or2 = o2.getAnnotation(Order.class); 
        if (or1 != null && or2 != null && or1.value() - or2.value() != 0) {
            return or1.value() - or2.value(); 
        }
        return o1.getName().compareTo(o2.getName()); 
    }

}