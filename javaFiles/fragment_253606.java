Set<String[]> set1 = new LinkedHashSet<>(Arrays.asList(Array1));
    Set<String[]> set2 = new LinkedHashSet<>(Arrays.asList(Array2));
    Set<String[]> set3 = new LinkedHashSet<String[]>();

    Iterator<String[]> it1 = set1.iterator();
    while (it1.hasNext()) {
        String[] element1 = it1.next();
        Iterator<String[]> it2 = set2.iterator();
        while (it2.hasNext()) {
            String[] element2 = it2.next();
            if (element1[0].equals(element2[0])
                  && element1[1].equals(element2[1])
                  && element1[2].equals(element2[2])) {
                set3.add(element1);
            }
        }
    }
    set3.toArray(new String[][]{});