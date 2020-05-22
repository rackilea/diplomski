public interface Sorting <V> {
    V getValue();   
    int compareTo(Sorting<V> other);
}

public class Testing implements Sorting<Integer>{

    public static void main(String [] args){
        Sorting<Integer> x1 = new Testing (4);
        Sorting<Integer> x2 = new Testing (5);
        System.out.println(String.format("compareTo is %d", x1.compareTo(x2));
    }

    private final int value;

    public Testing(int value){
        this.value = value;
    }

    @Override
    int getValue(){
        return value;
    }

    @Override
    public int compareTo(Sorting<Integer> other) {
        int otherValue = other.getValue();
        if(value > otherValue)
            return 1;
        else if(value < otherValue)
            return -1;
        return 0; // must be ==
    }
}