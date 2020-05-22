int[] arr = new int[]{8, 15, 2,10, 11,15,1,3}; 

System.out.println("array before rotation: " + Arrays.toString(arr));

int lastElement = arr[arr.length -1 ];
System.arraycopy(arr, 0, arr, 1, arr.length-1);
arr[0] = lastElement;

System.out.println("array after rotation: " + Arrays.toString(arr));