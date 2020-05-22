final Set<GirlScoutCheck> al = new TreeSet<>();

try (final Scanner kb = new Scanner(System.in)) {
    do {
        // your stuff
        kb.nextLine();
    } while (!name.equalsIgnoreCase("runaway"));
}

// from now on, al will contain all the GirlScoutCheck's ordered "as you want"

for (final GirlScoutCheck gsc : al) {
    System.out.println(gsc);
}