int result = 0;
while (dividend >= divisor)
{
   dividend = dividend - divisor;
   result = result + 1;
}
remainder = dividend;
System.out.print(countDividend + " divided by " + countDivisor + " equals " + integer_result + " with a remainder of " + remainder);