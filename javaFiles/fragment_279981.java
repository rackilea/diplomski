public class Main{
    public static void main(String[] args){ }
    public static <T extends Comparable<? super T>> T max(Collection<? extends T> c){
        T max= c.iterator().next();
        for(T element : c){
            if(element.compareTo(max)>0) max=element;
        }
        return max; 
    }
}