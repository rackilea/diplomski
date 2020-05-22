static <T> void shuffleList(List<T> list) {
    List<T> temp = new ArrayList<T>(list);
    Random rand = new Random();

    for (int i = 0; i < list.size(); i++) {
        int newPos = rand.nextInt(list.size());
        while (newPos == i||temp.get(newPos)==null) {
            newPos = rand.nextInt(list.size());
        }
        list.set(i, temp.get(newPos));
        temp.set(newPos,null);
    }
}