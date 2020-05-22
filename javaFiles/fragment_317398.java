if (position < 1 || position > 46){
        System.out.println("Not a valid number");
    } 
    else {
        for (loopCount = 0; loopCount < position; loopCount++ ){
            fNew = fold1 + fold2;
            fold1 = fold2;
            fold2 = fNew;
            System.out.println("The " + position + " of the Fibonacci Sequence is " + fold1);                       
        }
    }