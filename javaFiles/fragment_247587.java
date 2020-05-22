int[] intArray = new int[20];
int index = 0;
loop:
   if(index >= intArray.length - 1){
        int[] temp = new int[intArray.length * 2];
        copyAll: intArray->temp // use System.arrayCopy
        intArray = temp;
   }
   intArray[index] = value;
   index++;
endloop:
// resize because intArray will likely be too big
int[] temp = new int[index];
copyAll intArray -> temp;
intArray = temp;