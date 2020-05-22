String[] original = input.split(" ");
List<String> finalList = new ArrayList<String>();

for (String s : original) {
    if (!finalList.contains(s)) {
        finalList.add(s);
    }
}

System.out.println("\nHere is the set list:");
displayList(finalList);
System.out.println("\n");