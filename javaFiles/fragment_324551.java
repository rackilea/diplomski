public static void main(String[] args) {
    String [] ar = {"0 11", "22 34", "5 14", "22 13"};

    Arrays.sort(ar, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            String [] value1 = o1.split(" ");
            String [] value2 = o2.split(" ");
            Integer o1First = Integer.valueOf(value1[0]);
            Integer o1Second = Integer.valueOf(value1[1]);
            Integer o2First = Integer.valueOf(value2[0]);
            Integer o2Second = Integer.valueOf(value2[1]);
            if (!o1First.equals(o2First))
                return o1First.compareTo(o2First);
            return o1Second.compareTo(o2Second);

        }
    });

    System.out.println(Arrays.toString(ar));
}