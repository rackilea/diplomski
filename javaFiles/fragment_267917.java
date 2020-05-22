List<Integer> arrTestA = new ArrayList<>();
List<Integer> arrTestB = new ArrayList<>();

[...]

List<Integer> common = new ArrayList<>(arrTestA);
common.retainAll(arrTestB);

List<Integer> diff = new ArrayList<>();
for(Integer element : arrTestA) 
    if(!common.contains(element))
        diff.add(element);

[here you print out elements of diff as The elements of A which is not in B]