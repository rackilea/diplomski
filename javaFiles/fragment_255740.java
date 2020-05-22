String ints = "15 1 1 4 6 4 7 11 8 10 6 10 13 6 10 15";
Scanner file = new Scanner(ints);
int[] array = new int[file.nextInt()];
int[] newArray = new int[array.length-4];
int counter = 0;
while (file.hasNextInt()) array[counter++] = file.nextInt();
for (int i = 0 ; i < array.length - 4 ; i++){
    for (int j = 0 ; j < 5 ; j++){
        newArray[i] += array[i+j];
    }
}
System.out.println(Arrays.toString(newArray));