String line = "(OR (OR tv party) (study)) (=> exam (NOT (OR tv party)))";
Scanner sc = new Scanner(line);
sc.useDelimiter("[^a-z]");
Set<String> set = new TreeSet<String>();
while(sc.hasNext()) {
    String word = sc.next();
    if (!word.isEmpty()) {
        set.add(word);
    }
}
System.out.println(set);