public class Test {
    public static void main(String[] args) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        User u1 = new User("1", "55", dateFormat.parse("2017-10-01 10:11:01.111"));
        User u2 = new User("1", "105", dateFormat.parse("2017-10-01 10:11:02.111"));
        User u3 = new User("2", "55", dateFormat.parse("2017-10-01 10:11:03.111"));
        User u4 = new User("2", "105", dateFormat.parse("2017-10-01 10:11:04.111"));
        List<User> sources = new ArrayList<>();
        sources.add(u1);
        sources.add(u2);
        sources.add(u3);
        sources.add(u4);


        List<User> destination = sources.stream()
                .collect(Collectors.groupingBy(User::getId, Collectors.maxBy(Comparator.comparing(User::getDate))))
                .values()
                    .stream()
                    .map(o -> o.get())
                    .collect(Collectors.toList());

        System.out.println(destination);
    }
}