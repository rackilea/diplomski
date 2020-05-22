public double[] addMissingNumber(double[] array1, double[] array2){  

             double[] arraynew = new double[max(array1.length,array2.length)];
              int i = 0;
              int j = 0;
              int k = 0;
              while ( i < array1.length && j < array2.length) {
                     arraynew[k] = array1[i] + array2[j];
                     i++;
                     j++;
                     k++
              }

              while(i < array1.length) {
                  arraynew[k] = array1[i]+1;
                  i++;
                  k++;
              }

               while(j < array2.length){
                   arraynew[k] = array2[j]+1;
                   j++;
                   k++;
               }

           return arraynew;
    }