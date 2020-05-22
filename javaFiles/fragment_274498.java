public void setList(int length){
    int key;
    testlist = new ArrayList<Integer>(); // add this and it will ensure that it's always a differen list
    Scanner xyz = new Scanner(System.in);
    for(int i=0;i<length;i++){
        testlist.add(xyz.nextInt());
    }
    System.out.println("Enter the key");
    key=xyz.nextInt();
    setMap(testlist, key); // it's always the same list if you don't create a new one
}