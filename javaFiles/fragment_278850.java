for (Set<Set<List<Integer>>> aSa : Sa) {
        for (Set<List<Integer>> bSa : aSa) {

            Iterator<List<Integer>> iter = bSa.iterator();

            while(iter.hasNext()) {
                System.out.println(iter.next());
            }
        }
 }