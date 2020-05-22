Set<Integer> set = new HashSet<>();

while(scan.hasNextInt()) {
    set.add(scan.nextInt());
}

if (set.contains(rand1)) {
    System.out.println("MATCH on rand1: " + rand1);
}

// repeat for rand2, rand3..etc