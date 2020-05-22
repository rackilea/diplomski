int[] arr = {1, 2};

// prints false, as the array in the list is not *identical*
System.out.println(Arrays.asList(new int[]{1, 2}).contains(arr));

// prints true, as the array in the list *is* identical
System.out.println(Arrays.asList(arr).contains(arr));