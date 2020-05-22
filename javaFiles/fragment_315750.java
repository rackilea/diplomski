public class Test6 {

    public static void main(String[] args) throws Exception {

        Integer[] list1 = { 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
        Integer[] list2 = { 26, 27, 28, 29, 30, 31 };
        Integer[] list3 = { 11, 12, 13, 14 };
        Integer[] list4 = { 13, 14 };
        Integer[] list5 = { 9, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };

        ArrayList<ArrayList<Integer>> main = new ArrayList<ArrayList<Integer>>();
        main.add(new ArrayList(Arrays.asList(list1)));
        main.add(new ArrayList(Arrays.asList(list2)));
        main.add(new ArrayList(Arrays.asList(list3)));
        main.add(new ArrayList(Arrays.asList(list4)));
        main.add(new ArrayList(Arrays.asList(list5)));

        for (ArrayList<Integer> list : main) {
            System.out.println(list);
        }

        removeDuplicates(main);

        System.out.println("________________________________________");

        for (ArrayList<Integer> list : main) {
            System.out.println(list);
        }

    }

    private static void removeDuplicates(ArrayList<ArrayList<Integer>> main) {
        // Sort the lists based on their size
        Collections.sort(main, new Comparator<ArrayList<Integer>>() {

            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return Integer.valueOf(o2.size()).compareTo(Integer.valueOf(o1.size()));
            }
        });

        for (ArrayList<Integer> list1 : main) {
            for (ArrayList<Integer> list2 : main) {
                if (list2 != list1) {
                    removeDuplicateNumbers(list1, list2);
                }
            }
        }
    }

    private static void removeDuplicateNumbers(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        for (Integer number : list2) {
            list1.remove(number);
        }
    }
}