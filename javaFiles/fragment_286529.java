static SortedSet<T> TailSet<T>(this SortedSet<T> set, T start)
{
    return new SortedSet<T>(set.SkipWhile(
        x => set.Comparer.Compare(x, start) < 0));
}

static SortedSet<T> HeadSet<T>(this SortedSet<T> set, T end)
{
    return new SortedSet<T>(set.TakeWhile(
        x => set.Comparer.Compare(x, end) < 0));
}