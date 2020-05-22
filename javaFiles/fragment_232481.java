public static void main(String[] args) {

    final int pageNumber = *X*;

    // list containing numbers from 1 to 100
    final List<Integer> list = populatedList();
    final int RESULTS_PER_PAGE = 10;

    // algorithm
    int to = pageNumber * RESULTS_PER_PAGE;
    int from = to - RESULTS_PER_PAGE;
    for (int i = from; i < to; i++) {
        System.out.println(list.get(i));
    }
}

public static List<Integer> populatedList() {
    List<Integer> list = new LinkedList<Integer>();
    for (int i = 1; i <= 100; i++) {
        list.add(i);
    }
    return list;
}