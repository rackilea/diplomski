private static <T> Comparator<List<T>> createComparator(
        final Comparator<? super T> delegate, final int... indices)
    {
        return new Comparator<List<T>>()
        {
            @Override
            public int compare(List<T> list0, List<T> list1)
            {

                    T element0 = list0.get(indices[0]);
                    T element1 = list1.get(indices[0]);
                    int n = delegate.compare(element0, element1);
                    if (n != 0)
                    {
                        return n;
                    }
                    else
                        return Integer.compare(Integer.parseInt(list0.get(indices[1]).toString()), Integer.parseInt(list1.get(indices[1]).toString()));
            }
        };
    }