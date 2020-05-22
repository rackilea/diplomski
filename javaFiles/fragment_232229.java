File file1= new File("C:\\Users\\Ramveer\\Desktop\\updates\\f1.txt");
File file2=new File("C:\\Users\\Ramveer\\Desktop\\updates\\f2.txt");
Scanner sc1=new Scanner(file1);
Scanner sc2=new Scanner(file2);
List<String> list1 = new ArrayList<String>()
List<String> list2 = new ArrayList<String>()

while(sc1.hasNextLine())
   list1.add(sc1.nextLine().toLowerCase());  //edited -- bad approach but would work if case not important


while(sc2.hasNextLine()){
   list2.add(sc2.nextLine().toLowerCase());  //edited -- bad approach but would work if case not important

Collections.sort(list1);
Collections.sort(list2);
for(String s: list1)
   System.out.println(s);