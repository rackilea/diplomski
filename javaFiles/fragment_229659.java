Stream<Integer> s = Stream.of(1,2,3,4,5);
List<Integer> list = s.collect(Collectors.toList());
int size = list.size();

List<List<Integer>> temp = new ArrayList<>();
List<Integer> temp2 = new ArrayList<>();

int index = 0;
for (int i=0; i<size; i++) {
    temp2.add(list.get(i));
    if (i%2!=0) {
        temp.add(temp2);
        temp2 = new ArrayList<>();
    }
    if (i == size - 1 && size%2!=0) {
        temp.add(temp2);
    }
}
Stream<Stream<Integer>> stream = temp.stream().map(i -> i.stream());