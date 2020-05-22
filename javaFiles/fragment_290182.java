List<Integer> list = new ArrayList<Integer>();

for (int i = 1; i <= 6; i++) {
    list.add(i-1, new Integer(i));
}

int j = 0;
while (j < 100) {
    Collections.rotate(list, -1);
    System.out.print("{");
    for (Integer integer : list) {
        System.out.print(integer + ", ");
    }
    System.out.println("}");
}