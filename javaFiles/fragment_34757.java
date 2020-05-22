for (i = 0; i < j; ) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--; 

            } 
            else {

                 j--;
             }
             count++;
        }