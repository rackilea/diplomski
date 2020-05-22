static int findKthMin(int[]arr, int n, int k) {
        int l=0 , r=n-1;
        Random random = new Random();
        while(true) {
            int x = random.nextInt(r+1-l) + l; // When using x = r (works correctly)

            //Swap random pivot with the last index element
            int temp = arr[x];
            arr[x] = arr[r];
            arr[r] = temp;

            int pivot = arr[r];

            int idx = l;
            for(int i=l;i<=r;i++) {
                if(arr[i] < pivot) {
                    temp = arr[idx];
                    arr[idx] = arr[i];
                    arr[i] = temp;

                    idx++;
                }
            }
            arr[r] = arr[idx];
            arr[idx] = pivot;

            if(idx == k-1) return pivot;

            if(idx > k-1) {
                r = idx-1;
            } else {
                l = idx;
            }
        }
    }