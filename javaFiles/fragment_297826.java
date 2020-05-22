int [] orig = new int[num];
for(int i=0;i<num;i++){
    int num2 = Integer.parseInt(JOptionPane.showInputDialog("Element: "+(i+1)));
    orig[i]=num2;
}
int [] copy = Arrays.copyOf(orig, orig.length);
bubbleSort(copy);
printArray(copy);
copy = Arrays.copyOf(orig, orig.length);
selectionSort(copy);
printArray(copy);
copy = Arrays.copyOf(orig, orig.length);
insertionSort(copy);
printArray(copy);