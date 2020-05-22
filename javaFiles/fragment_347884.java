public static List<String> findFirst(String v, List<Grammar> l) {
    Set<String> first = new TreeSet<>();

    Set<String> done = new HashSet<>();
    done.add(v);

    Grammer previous = null;
    for (Grammar gr : l) {
        if (v.equals(gr.term)) {
            String s = gr.prod.split(" ")[0];
            if (!isNonTerm(s)) { // is a terminal
                first.add(s);
            }

            // if the rhs is a terminal 
            if (s.equalsIgnoreCase("empty") && previous != null) {
                String[] stemp = previous.prod.split(" ");

                if (v.equalsIgnoreCase(stemp[0]) && stemp.length > 1
                        && done.add(stemp[1])) {
                    first.addAll(findFirst(stemp[1], l)); // <--------- Here it happened
                }
                //if the rhs is empty , then get the previous grammar 
                //split it.
                //find the first of it and ad it to the first list
            }
            if (!v.equals(s) && isNonTerm(s) && done.add(s)) {
                first.addAll(findFirst(s, l));
            }
        }
        previous = gr;       
    }
    return new ArrayList<String>(first);
}