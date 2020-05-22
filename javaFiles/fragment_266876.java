public static void main(String[] args)  {
        int arr[] = { 12, 11, 13, 5, 6 };
        int len = arr.length;
        for(int i=1; i<len; i++) {
            int key = arr[i];
            for (int j=i-1; (j >= 0 && arr[j] > key); j--) { 
                arr[j + 1] = arr[j];  
            } 
            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));
        }
    }