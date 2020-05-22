class Scratch
{
    interface A extends Comparable<A> {}
    interface B extends A {}

    public static <T extends Comparable<? super T>> T findMax(List<? extends T> list)
    {
        return null;
    }

    public static <T extends Comparable<? super T>> T findMax2(List<T> list)
    {
        return null;
    }

    public static void main(String[] args)
    {
        List<B> listOfBs = new ArrayList<>();

        A foo = Scratch.<A>findMax(listOfBs);  // fine
        A bar = Scratch.<A>findMax2(listOfBs); // compiler error
    }
}