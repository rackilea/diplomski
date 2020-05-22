public class Example {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();      

        //initial capacity of the nested arraylist to 5.  
        System.out.println(bucket.add(new ArrayList<>(5)));
        ArrayList<Integer> element = new ArrayList<>();
        element.add(5);
        bucket.add(0, element);
        System.out.println(bucket);
    }

}