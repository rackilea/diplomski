List<Integer> srcList = Arrays.asList(10, -3, 5), dstList = new ArrayList<>();

int value = 0;
for(Integer i: srcList) {
    value = i + value/2;
    dstList.add(value);
}