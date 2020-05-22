if(sum == 13) {
            for(int i=low;i<=high;i++) {
                System.out.println(a[i]);
            }
            System.out.println("new ");
            low++;
            high++; // change to high = low; // since you want your loop to test 
                    // sequences that start at the new (post incremented) low
            sum = 0; // change to sum = a[low]; // since the initial sum is the value of
                     // the first element in the new sequence
        }