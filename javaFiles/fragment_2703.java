boolean search=true;
while(search) {
  System.out.print("Search..");
  String searchFor = keyboard.nextLine();
  int ind = searchList.indexOf(searchFor);
  if (ind == -1) {
    System.out.println("Not Found");
  } else {
    System.out.print("Replace with.. ");
    String replaceWith = keyboard.nextLine();
    searchList.set(ind, replaceWith);
  }
  System.out.print("Continue searching.. ");
  String ans = keyboard.nextLine( );
  if (!ans.equalsIgnoreCase("yes"))
    search = false;
}