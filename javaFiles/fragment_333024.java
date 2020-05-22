int[] numbersAdd = new int[numbers.length];
int i = 0;
int j = 0;
while(j < numbers.length - 1) {
    int add = numbers[i] + numbers[i+1];
    numbersAdd[j] = add;
    i++;
    j++;
}
numbersAdd[numbers.length - 1] = numbers[numbers.length - 1];