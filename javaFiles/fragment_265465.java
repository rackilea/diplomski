Scanner in = new Scanner(System.in);
String[] line = new String[8];
String[] rows = new String[7];


int player=0,j=0;

for (int i =0; i <3 ;++i) {
line[i] = in.nextLine();
System.out.println("REading ..."+line[i]);
rows = line[i].split("\\s+");
j=0;
int[] row_int = new int[7]; //reinitializing the variable on each loop
for (String s : rows) {
    row_int[j]=Integer.parseInt(s);
    j++;
}
input[i]=row_int;
System.out.println(Arrays.toString(row_int)+" for the value of i  "+i);
System.out.println("The Array is \n"+Arrays.deepToString(input));
}