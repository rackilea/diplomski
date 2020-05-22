List<String> eachRows = new ArrayList<>();
while (input.hasNext())
    eachRows.add(input.nextLine());

input.close();

Collections.sort(eachRows);
for(String s : eachRows)
    System.out.println(s);