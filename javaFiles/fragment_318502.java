const isOdd = v => v % 2 == 1;
const multiply = by => v => v * by;    

const arrRange = IntStream.range(10, 20);
const arrOdd = arrRange.filter(isOdd);
const arrOddM3 = arrOdd.map(multiply(3));