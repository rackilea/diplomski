Scanner fin = new Scanner(new FileReader(file);
String pattern = ",";
fin.useDelimiter(pattern);
while (fin.hasNext()) {
    String s = fin.nextLine();
    String[] arr = s.split(pattern);
    int processID = Integer.parseInt(arr[0]);
    int time = Integer.parseInt(arr[1]);
}