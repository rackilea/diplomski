int[] x = {7, 6, 6, 5, 3, 2, 1 };
    //Declare an int array with length = x.length+1;
    int[] bigger = new int[x.length+1];
    int add = 4;
    /** Define a variable to indicate that if a property location is found.*/
    boolean found = false;
    /** Define a variable to store an index for insert*/
    int indexToInsert = 0;
    for (int i = 0; i < x.length; i++){
         if ( !found && add >= x[i]){
             found = true;
             indexToInsert = i;
             bigger[indexToInsert] = add;
             i--;
         }
         else{
             if(found)
             {
                 bigger[i+1] = x[i]; 
             }else
             {
                 bigger[i] = x[i];
             }

         }
    }

    /*
     * If a property index is not found. Then put the value at last. 
     */
    if(!found)
    {
        indexToInsert = x.length;//
        bigger[indexToInsert] = add;
    }