for (termIndex=0; termIndex<termArray.length; termIndex++) 
    {
        counter=0; //Reset the counter for each word in termArray
        found=false; //Reset the "found" flag for each word in termArray
        for (searchIndex=0; searchIndex<searchArray.length; searchIndex++) 

            if (termArray[termIndex].equalsIgnoreCase(searchArray[searchIndex]))
            {
                counter++;
                percentage= ((double) counter/(double)total) * 100;

                found=true
                System.out.println("Search word " + "\'" + termArray[termIndex] + "\' is found " +counter +" times. That is "+ two.format(percentage)+"% of the statement." );
            }
        }
        if (found) 
                System.out.println("Search word " + "\'" + termArray[termIndex] + "\' is found " +counter +" times. That is "+ two.format(percentage)+"% of the statement." );
        else  
                System.out.println("Search word " + "\'" + termArray[termIndex] + "\' is not found in the statement.");

    }