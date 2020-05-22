if(var != -1){
    int temp=myList.get(var);
    int n = findSmallestFactor(temp);
    myList.set(var, n);
    myList.add(temp/n);
    generateList();
}