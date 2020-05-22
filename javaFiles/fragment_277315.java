int sumTotal = 0; // declare the variable you want to to summerize outside the loop. If you declare it inside the loop it will be garbage collected once the loop finishes and the variable is lost
    for(int i=0 ; i<arrayOne.size() ; i++){
        sumTotal+=arrayOne.get(i); // add the value that is at the current index each iteration

    }
//After the loop, somTotal will have the total added value of the integers in the `List`. Now you can continue from here