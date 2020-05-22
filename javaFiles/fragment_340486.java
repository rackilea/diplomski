for (String p: newStrSet) {
    System.out.printf("%s -> [", p);
    boolean needComma = false;

    // Use indices instead of a for-each so you can 
    // check if there's a next element
    for (int i = 0; i < personFile.size(); ++i) {
        Codes2 s = personFile.get(i);

        if (s.getUserNameGenerator().contains(p)) {
            // Only print out the comma and space if there's a preceding element
            if (needComma) {
                System.out.print(", ");
            }

            System.out.printf("%s", s.getPersonName());

            needComma = true;
        }
    }

    System.out.println("]");
}