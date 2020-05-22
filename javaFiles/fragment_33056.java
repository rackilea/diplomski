if (i > mid) { // all the elements between lo and mid were already merged
                       // so all that is left to do is add the remaining elements 
                       // from aux[j] to aux[hi]
            theArray[k] = aux[j++];
        }
        else if (j > hi) { // all the elements between mid+1 and hi were already merged
                           // so all that is left to do is add the remaining elements 
                           // from aux[i] to aux[mid]
            theArray[k] = aux[i++];
        }
        else if (aux[j] < aux[i]) { // both source arrays are not done, so you have to
                                    // compare the current elements of both to determine
                                    // which one should come first
            theArray[k] = aux[j++];
        }
        else {
            theArray[k] = aux[i++];
        }