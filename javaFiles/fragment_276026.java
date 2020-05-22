public class OutterClass {  

  int numberLength; // <== not *final*

  class PhoneNumber {

    PhoneNumber(String phoneNumber) {
        numberLength = 7;   // <== assignment to numberLength
        String currentNumber = phoneNumber.replaceAll(
            regularExpression, "");
        if (currentNumber.length() == numberLength)
            formattedPhoneNumber = currentNumber;
        else
            formattedPhoneNumber = null;
     }

  ...

  }

...

}