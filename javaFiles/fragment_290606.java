public class CustomTupleComparator<T1 extends Comparable<? super T1>, 
                                   T2 extends Comparable<? super T2>> 
             implements Comparator<Tuple<T1, T2>>
{
    @Override
    public int compare(Tuple<T1, T2> o1, Tuple<T1, T2> o2)
    {
        int result = o1.getSecond().compareTo(o2.getSecond());

        return result != 0 ? result
                           : -o1.getFirst().compareTo(o2.getFirst());
    }
}