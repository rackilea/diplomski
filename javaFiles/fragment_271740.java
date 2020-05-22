while (input.hasNextInt()) {
    int i = input.nextInt();
    a.add(i);
}
input.next();
Collections.sort(a);
System.out.print("Enter a value which you wish to search in the array");
int value = input.nextInt();