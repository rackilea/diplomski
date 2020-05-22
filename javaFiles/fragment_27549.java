BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
System.out.println("How many elements you want to add to the array: ");
int n = Integer.parseInt(in.readLine());
System.out.println("enter numbers : ");
TreeSet<String> setA = new TreeSet<String>();
for (int i = 0; i < n; i++) {
    setA.add(in.readLine());
}

System.out.println(setA.toString());