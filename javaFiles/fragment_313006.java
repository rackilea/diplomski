List<Integer> allKids;
allKids = new ArrayList<>();

for( ... ) {
    .
    .
    .
    allKids.add(days);
    .
    .
    .
}

int total;
total = allKids.stream().mapToInt(Integer::intValue).sum();
System.out.print(total);