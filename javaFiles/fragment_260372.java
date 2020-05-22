int[] arr = {33,44,22,11,22,11};
  for (int i = 0; i < arrSort.length - 1; i++) {
                    for(int j=i;j<arrSort.length; j++) {
                         if (arr[i] > arr[j]) {
                                temp = arr[j];
                                arr[j] = arr[i];
                                arr[i]=temp;
                            }
                    }   
  System.out.println(Arrays.toString(arr));