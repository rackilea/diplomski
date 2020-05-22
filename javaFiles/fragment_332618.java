...

var toReturnDigits = [];

for (int i = 0; i < arrayLength; i++) {
  if (parseInt(charArray[i].toString(), 10)) { //assuming you expect base 10 digits
     toReturnDigits.push(charArray[i]);
    }
 }
return toReturnDigits;