public static void main(String[] args) {
    List<LocalDate> list = Arrays.asList(
                                      LocalDate.of(2018, 10, 1), LocalDate.of(2018, 10, 20),
                                      LocalDate.of(2018, 10, 14),LocalDate.of(2018, 10, 2));
    System.out.println(list);
    LocalDate now = LocalDate.now();

    list.sort((o1, o2) -> {
        if (o1.isBefore(now) && o2.isBefore(now) || o1.isAfter(now) && o2.isAfter(now)) {
            return o1.compareTo(o2);
        }
        return o2.compareTo(o1);
    });

    System.out.println(list);
}


[2018-10-01, 2018-10-20, 2018-10-14, 2018-10-02]
[2018-10-14, 2018-10-20, 2018-10-01, 2018-10-02]