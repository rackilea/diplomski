List<Integer> mylist = new ArrayList<>();
Scanner scanner = new Scanner(System.in);
for(int i=0 ; i < 5 ; i++){
    mylist.add(scanner.nextInt());
}
System.out.println(mylist);
scanner.close();