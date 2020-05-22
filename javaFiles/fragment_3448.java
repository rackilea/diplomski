Scanner sc = new Scanner(System.in);
String str = sc.nextLine();
int k = sc.nextInt();

List<String> cutStrings = new ArrayList<String>();
for (int i = 0; i < str.length() - k; i++) {
    cutStrings.add(str.substring(i, i + k));
}

Collections.sort(cutStrings);
System.out.println(cutStrings.get(0));
System.out.println(cutStrings.get(cutStrings.size()-1));