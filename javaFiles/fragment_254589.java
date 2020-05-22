ArrayList<Integer> list = new ArrayList<>(11);
for (int i = 0; i <= 10; i++){
    list.add(i);
}
int[] a = new int[size];
for (int count = 0; count < size; count++){
    a[count] = list.remove((int)(Math.random() * list.size()));
}