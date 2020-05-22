public static <T extends Comparable<? super T>> Collection<T> sort(T[] list) {

        Collection<T> list = new ArrayList<T>();

         //do quicksort
        Arrays.sort(arr);

        Collection<T> list = new ArrayList<T>();
        int i;
        for(i=0; i<arr.length-1; i++) {
            if(arr[i].compareTo(arr[i+1]) != 0) { //if not duplicate, add to the list
                list.add(arr[i]);
            }
        }
        list.add(arr[i]); //add last element
//btw how do You know that last is not duplicate 
        return list;

}