int index = -1;

for(int i = 0; i < numberButtons; i++){
        if(i%3 == 0) {
          index += 1;
          tableRow[index] <- add Button here //here it's a new row we update the index
        }
        else
          tableRow[index] <- add Button here //we can add button to the current index
                                             //because there are less than 3 buttons
}