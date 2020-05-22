if (i < x){
    //we use this variable to count the number of leap years that we already found
    int noOfResults = 0;
    String results = "";
    for (; i < x; i ++ ){ //i loops over the years
        //i is a leap year when this expression is true:
        if(i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
            //add the leap year to the result string:
            results += i + " ";
            //increase the number of found results by 1:
            noOfResults++;
            //for every 5th result, we add a line break to the result string
            // this is done with the % sign, the modulo operator
            // which returns the remainder of a division
            // meaning that everytime we loop through this, it is
            // checked if the remainder of noOfResults divided by 5 is zero
            if(noOfResults % 5 == 0){
                results += "\n";
            }
        }
    }
    JOptionPane.showMessageDialog(null, results);
}