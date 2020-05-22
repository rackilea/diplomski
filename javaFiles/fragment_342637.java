long millis = 0;
String[] numbers = dateString.split(".");
millis += Integer.parseInt(numbers[numbers.length-1]) * 
          (int)Math.pow(10,numbers[numbers.length-1].length()-3));
for (int i=2; i<=numbers.length; i++) {
  millis += Integer.parseInt(numbers[numbers.length-i]) *
            (int)Math.pow(60,i-1) * 100;
}