public class FancyConstants {
    public static final List<Person> student_list;
    static {
        ImmutableList.Builder<Person> builder = new ImmutableList.Builder<Person>();
        builder.add(new Person("Amy",12,56));
        builder.add(new Person("Tom",26,79));
        .........
        /* More similar definitions; could be very long */
        builder.add(...);
        student_list = builder.build();
    }
}