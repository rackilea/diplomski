for (rowIndex = 0; rowIndex <= stringLength; rowIndex++){ //here
    for (columnIndex = 0; columnIndex < encryptedArr[rowIndex].length;columnIndex++){
         while (indexOfString <= stringLength){
          charToEncrypt = toEncrypt.charAt(indexOfString)
          charValue = charToEncrypt;
          encryptedArr[rowIndex][columnIndex] += charValue;
          indexOfString++;
     }
  }