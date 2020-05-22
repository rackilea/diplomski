ArrayList<Integer> alist = new ArrayList<>();
LinkedList<Integer> arr2 = new LinkedList<>(Arrays.asList(array2));

if(arr2.contains(array1[0])){
   Iterator<Integer> x = arr2.listIterator(arr2.indexOf(array1[0]));
   ...
   ...