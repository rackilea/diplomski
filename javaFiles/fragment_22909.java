List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
int index[] = new int[]{0};

// Prints 4 and 8
Iterator<Integer> iterator = list.iterator();
iterator.forEachRemaining(i -> {
    if ((index[0]+1)%4 == 0) {
        // Here you work both with the element `i` and its index `index[0]`
        System.out.println(i);     
    }
    index[0]++;
});