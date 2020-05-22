Map<Integer, Integer> numbersWithCount = new HashMap<>();

now you loop over your data; and for each data point:

int currentNumber = ... next number from your input data

int counterForNum;
if (numbersWithCount.containsKey(currentNumber)) {
  counterForNum = numbersWithCount.get(currentNumber) + 1;
} else {
   // currentNumber found the first time
  counterForCurrentNumber = 1;
}
numbersWithCount.put(currentNumber);