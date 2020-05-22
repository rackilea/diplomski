if(duplicate==1) {
                for(k=0; k<m; k++) { // increase k
                    if(a[i] == b[k]) {
                        intersect = intersect + 1;
                        break; // insert break to avoid duplicates in b array
                    }
                }
            }