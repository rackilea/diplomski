public static void main(String args[]) {

            int [] a = new int[] {2, 3, 3, 1, 5, 2};
            // Each element of cntarray will hold the number of occurrences of each potential number in the input (cntarray[n] = occurrences of n)
            // Default initialization to zero's 
            int [] cntarray = new int[a.length + 1]; // need +1 in order to prevent index out of bounds errors, cntarray[0] is just an empty element

            int min = -1;
            for (int i=0;i < a.length ;i++) {
                if (cntarray[a[i]] == 0) {
                    cntarray[a[i]]++;
                } else {
                    min = a[i];
                    // no need to go further
                    break;
                }
            }
            System.out.println(min);
        }