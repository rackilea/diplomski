static <T> void shuffleList(List<T> list) {
    List<T> temp = new ArrayList<T>(list);
    Integer [] indexes=new Integer[list.size()];
    for (int i=0;i<list.size();i++){
        indexes[i]=i;
    }
    Random rand = new Random();

    for (int i = 0; i < list.size(); i++) {
        int newPos = rand.nextInt(list.size());
        while (newPos == i||indexes[newPos]==null) {
            newPos = rand.nextInt(list.size());
        }
        list.set(i, temp.get(newPos));
        indexes[newPos]=null;
    }
}