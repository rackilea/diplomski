private Set<List<Integer>> firstElementSingle(List<Integer> numbers) {
    Set<List<Integer>> result compute(numbers.subList(1,numbers.size()) );
    for(List<Integer> list : result) {
        list.add(numbers.get(0));
    }
    return result;
}