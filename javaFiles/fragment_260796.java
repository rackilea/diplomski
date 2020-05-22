start:
    for (int i = 0; i < a.length; i++){


        for (int k = 0; k < b.length; k++){

            if ( a[i].equals( b[k])  ){
                hold+=a[i];
                break start;
            }//if

        }//for


    }//for