if (value <= 9)
    return 0;
int lastDigit = value % 10;
int higherDigits = value / 10;
int secondLastDigit = higherDigits % 10;
int difference = Math.abs(secondLastDigit - lastDigit);
int higherReduced = reduce(higherDigits); // recursive call
int result = higherReduced * 10 + difference;
return result;