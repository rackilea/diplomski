import java.util.*;

class PredefinedOrderingComparator<T> implements Comparator<T> {
    List<T> predefinedOrdering;

    PredefinedOrderingComparator(List<T> predefinedOrdering) {
        this.predefinedOrdering = predefinedOrdering;
    }

    @Override
    public int compare(T t1, T t2) {
        return predefinedOrdering.indexOf(t1) - predefinedOrdering.indexOf(t2);
    }
}

class Main {
    public static void main(String[] args) {
        List<String> l = Arrays.asList(
            "tendercoupon",
            "giftcard",
            "creditCard",
            "tendercoupon",
            "giftcard"
        );
        System.out.println(l);

        Comparator<String> comparator = new PredefinedOrderingComparator(Arrays.asList(
            "creditcard",
            "paypal",
            "giftcard",
            "tendercoupon"
        ));

        Collections.sort(l, comparator);
        System.out.println(l);
    }
}