public static void main(String[] args) {

    List<Integer> ids = List.of(1, 2, 3);
    List<Double> taxes = List.of(10.25, 1.58, 30.28);
    List<Double> taxes2 = List.of(10.25, 1.57, 28.28);

    for (int i = 0; i < ids.size(); i++) {
        int id = i + 1;
        int result = taxes.get(i).compareTo(taxes2.get(i));

        if (result != 0) {
            System.out.println(
                    "value for id:" + id
                            + " is changed  old value: " + taxes.get(i)
                            + ",new value is: " + taxes2.get(i));
        }
    }
}