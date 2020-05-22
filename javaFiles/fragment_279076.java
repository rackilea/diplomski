private int getRandomNumberFromArray(){
     int min = 0;
     int max = numbers.length;

     return numbers[min + (int)(Math.random() * ((max - min) + 1))];
}