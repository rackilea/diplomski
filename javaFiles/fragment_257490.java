int number = 1234;
int length = Integer.toString(number).length();
int[] a = new int[length];

int index = length - 1;
for (int i = 0; i < length; i++){
    a[i] = number % 10;
    number = number / 10;
    index--;
}