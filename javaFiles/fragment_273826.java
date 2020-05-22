for(int i = 0; i < encryptMessageArray.length; i++) {
    for(int j = 0; j < innerRotorClockWise.length; j++) {
        if(encryptMessageArray[i].equals(innerRotorClockWise[j])) {
            indexNumber = indexNumber + j +  " ";
            //encrypt the first letter
            System.out.println("");
            System.out.println("Inner Index Number: " + indexNumber);
            System.out.println("");
            break;
        }
    }
    innerRotorClockWise(); //change theencrypted letter bank
                           // repeat
}