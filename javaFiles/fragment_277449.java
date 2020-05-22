/** setup test data and call {@link #sum(Vector)} */
public static void main(String[] args) {
    Vector a = new Vector();
    Vector b = new Vector();

    a.add(1.0);
    a.add(2.0);
    b.add(3.0);

    System.out.println(sum(a, b));
}

/** Sum up all values of two vectors */
private static double sum(Vector value, Vector value1) {
    return sum(value) + sum(value1);
}

/** Sum up all values of one vector */
private static double sum(Vector value) {
    return

            // turn your vector into a stream
            value.stream()

            // make the stream of objects to a double stream (using generics would
            // make this easier)
            .mapToDouble(x -> (double) x)

            // use super fast internal sum method of java
            .sum();
}