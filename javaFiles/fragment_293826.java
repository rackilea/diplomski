System.out.println("do you want to add a Book?(yes or no) ");
Scanner s=new Scanner(System.in);
String h = s.nextLine();
while (h.contains("yes")|| h.compareToIgnoreCase("YES") == 0) {
int size=list.size();
//your code here
System.out.println("do you want to add a Book?(yes or no) ");
h = s.nextLine();
}