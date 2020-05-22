protected void fetch(Root<T> root, String... joins) {
    //Sort the joins so they are like this :
    //A
    //A.F
    //B.E
    //B.E.D
    //B.G
    Arrays.sort(joins);

    Map<String, Fetch> flattenFetches = new HashMap<>();

    for (String join : joins) {
        try {
            if (join.contains(".")) {
                String[] subrelations = join.split("\\.");
                Fetch lastRelation = null;
                int i;

                for (i = subrelations.length - 1; i >= 0; i--) {
                    String subJoin = String.join(".", Arrays.copyOf(subrelations, i));

                    if (flattenFetches.containsKey(subJoin)) {
                        lastRelation = flattenFetches.get(subJoin);
                        break;
                    }
                }

                if (lastRelation == null) {
                    lastRelation = root.fetch(subrelations[0], JoinType.LEFT);
                    flattenFetches.put(subrelations[0], lastRelation);
                    i = 1;
                }

                for (; i < subrelations.length; i++) {
                    String relation = subrelations[i];
                    String path = String.join(".", Arrays.copyOf(subrelations, i + 1));

                    if (i == subrelations.length - 1) {
                        Fetch fetch = lastRelation.fetch(relation, JoinType.LEFT);
                        flattenFetches.put(path, fetch);
                    } else {
                        lastRelation = lastRelation.fetch(relation, JoinType.LEFT);
                        flattenFetches.put(path, lastRelation);
                    }
                }
            } else {
                Fetch fetch = root.fetch(join, JoinType.LEFT);
                flattenFetches.put(join, fetch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}