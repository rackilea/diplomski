Scanner input1= new Scanner(new File("C:/file1.txt");
 Scanner input2= new Scanner(new File("C:/file2.txt");
 String one= input1.nextLine();//assuming files contain only one line
 String two= input2.nextLine();//assuming files contain only one line
 Set<String> set1 = new HashSet<String>(Arrays.asList(one.split(";"));
 Set<String> set2 = new HashSet<String>(Arrays.asList(two.split(";"));

 System.out.println(set1.equals(set2));