ArrayList<Integer> input = new ArrayList<>();
Deque<Integer> d = new LinkedList<>();

input.add(10);
input.add(3);
input.add(5);
input.add(6);
input.add(15);

for (Integer i : input) {
    if (i % 2 == 1) {
        d.addLast(i);
    } else {
        d.addFirst(i);
    }
}

System.out.println(d);