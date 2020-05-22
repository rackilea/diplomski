List<List<Integer>> arr1 = new ArrayList<List<Integer>>();        
List<List<Integer>> arr2 = new ArrayList<List<Integer>>();

arr1.add(Arrays.asList(new Integer[]{1, 2, 3}));
arr1.add(Arrays.asList(new Integer[]{1, 2, 3}));
arr1.add(Arrays.asList(new Integer[]{1, 2, 2}));
arr1.add(Arrays.asList(new Integer[]{1, 2, 3}));
arr1.add(Arrays.asList(new Integer[]{1, 1, 1}));
arr1.add(Arrays.asList(new Integer[]{1, 1, 1}));

arr2.add(Arrays.asList(new Integer[]{1, 2, 3}));
arr2.add(Arrays.asList(new Integer[]{1, 2, 2}));

System.out.println(arr1);
System.out.println(arr2);

Set<List<Integer>> set1 = new HashSet<List<Integer>>();        
Iterator<List<Integer>> it = arr1.iterator(); 

while(it.hasNext()) {
    List<Integer> curr = it.next();
    if(!set1.add(curr) && arr2.contains(curr)) {
        it.remove();
    }
}

System.out.println(arr1);