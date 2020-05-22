Map<Candidate, Integer> map = new HashMap<Candidate, Integer>();
for (Candidate c: Candidates) {
    if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
    } else {
        map.put(c, 1);
    }
}