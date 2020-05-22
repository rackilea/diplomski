TreeMap<String, String> map = new TreeMap<>();
    map.put("Delhi", "State");
    map.put("New Delhi", "State");
    map.put("New York", "State");
    String[] a = map.keySet().toArray(new String[0]);
    Set<String> found = new HashSet<>();

    Scanner s = new Scanner("First is Delhi, next is New Delhi");
    s.useDelimiter("[ .,\n\t\r]");
    String prev = "";    // previous word
    while (s.hasNext()) {
        String n = s.next();
        if (!prev.isEmpty()) {
            n = prev + n;
        }
        int i = Arrays.binarySearch(a, n);
        if (i >= 0) {
            found.add(n);
            prev = "";
        } else {
            i = -i - 1;
            if (i < a.length && a[i].startsWith(n)) {
                prev = n + " ";
            } else {
                prev = "";
            }
        }
    }
    System.out.println(found);