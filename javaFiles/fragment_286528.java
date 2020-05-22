static SortedSet<T> TailSet<T>(this SortedSet<T> set, T start)
{
    return set.GetViewBetween(start, set.Max);
}

static SortedSet<T> HeadSet<T>(this SortedSet<T> set, T end)
{
    return set.GetViewBetween(set.Min, end);
}