public class DoubleSumDemo {

    public static void main(String[] argv) {
        final ArrayList<Double> list = new ArrayList<Double>();
        // fill list with random values
        for (int i=0; i<1000000; ++i)
            list.add(Math.random());
        // sum the list, print the sum and then reorder the list elements
        while (true) {
            double sum = 0D;
            for (double element : list) 
                sum += element;
            System.out.println("sum is: " + sum);
            Collections.shuffle(list);
        }
    }

}