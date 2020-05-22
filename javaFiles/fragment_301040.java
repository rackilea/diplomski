int dupCount = 0;
for (int i = 0; i < size; i++){
    for (int j = 0; j < size; j++){
        if (b[i] == a[j]){
            Duplicate = a[j];
            System.out.println(Duplicate);
            dupCount = 0;
        }
    }
}
if (dupCount == 0)
    System.out.println("No common variable");