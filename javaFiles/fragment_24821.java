public static void makePattern(int thisRow, int num) { 
        //the termination condition
        if(thisRow == num * 2) 
           return;

        //the number of spaces
        int numberOfSpaces = 0;     
        if(num < thisRow) {
          numberOfSpaces = thisRow - num;
        } else {
          numberOfSpaces = num - thisRow;
        }

        //the number of stars
        int numberOfStars = num - numberOfSpaces;

        //compose the string before printing it
        StringBuffer outputBuffer = new StringBuffer(num);
        for (int i = 0; i < numberOfSpaces; i++){
            outputBuffer.append(" ");
        }
        for (int i = 0; i < numberOfStars; i++){
            outputBuffer.append("* ");
        }

        //print the string
        System.out.println(outputBuffer.toString());

        //recursion
        makePattern(thisRow + 1, num);
   }