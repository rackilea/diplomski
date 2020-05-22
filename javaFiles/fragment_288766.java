...
    String[] cols = ... //linea in input
    Set<String> subSet= new HashSet<String>();
    Set<Set<String>> sets = new HashSet<Set<String>>();

    //popolo l'insieme - escludo la data
    for(int i=1; i<cols.length; i++){
        subSet.add(cols[i]);
    }


    // creo l'insieme delle parti e popolo
    sets = powerSet(subSet);

 public static Set<Set<String>> powerSet(Set<String> originalSet) {

    Set<Set<String>> sets = new HashSet<Set<String>>();
    if (originalSet.isEmpty()) {
        sets.add(new HashSet<String>());
        return sets;
    }
    List<String> list = new ArrayList<String>(originalSet);
    String head = list.get(0);
    Set<String> rest = new HashSet<String>(list.subList(1, list.size()));
    for (Set<String> set : powerSet(rest)) {
        if(set.size() < 5){
            Set<String> newSet = new HashSet<String>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
    }

    return sets;
}