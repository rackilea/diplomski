Scanner inFile = new Scanner(new File(filename));
List<char[]> temps = new ArrayList<char[]>();
while (inFile.hasNext()) {
    temps.add(inFile.nextLine().toCharArray());
}
inFile.close();
char[][] wholeData = temps.toArray(new char[0][]);
//just to show the data
System.out.println(Arrays.deepToString(wholeData));