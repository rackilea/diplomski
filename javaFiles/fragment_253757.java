public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student(101, "Abc ghi", "USA"));
        list.add(new Student(102, "DEF", "UST"));
        list.add(new Student(103, "Ghi ab", "DSjkD"));
        list.add(new Student(104, "jKL ut", "USN"));
        list.add(new Student(105, "MNP", "TSA101"));
        list.add(new Student(106, "UTC ABC", "ESA"));

        List<String> sugg = query("01", list);
        sugg.forEach(System.out::println);
    }