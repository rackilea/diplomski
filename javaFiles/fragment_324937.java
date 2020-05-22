public static void getAllPermutations(final List<Integer> data,
    final Set<Integer> holder){

    if(data.isEmpty()){
        return;
    }
    final Integer first = data.get(0);
    if(data.size() > 1){
        getAllPermutations(data.subList(1, data.size()), holder);
        for(final Integer item : new ArrayList<Integer>(holder)){
            holder.add(first.intValue() + item.intValue());
        }
    }
    holder.add(first);
}