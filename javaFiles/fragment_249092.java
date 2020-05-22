public class Experiment {
    public static <E> void funct1(final List<E> list) {
        list.add(list.get(0));
    }

    public static void funct2(final List<?> list) {
        list.add(list.get(0)); // !!!!!!!!!!!!!! won't compile !!!!!!!!!
    }
}