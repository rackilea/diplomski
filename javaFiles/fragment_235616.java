public class Concatenation<T> : IEnumerable<T>
{
    private readonly IEnumerable<T> first;
    private readonly IEnumerable<T> second;

    public Concatenation(IEnumerable<T> first, IEnumerable<T> second)
    {
        this.first = first;
        this.second = second;
    }

    public IEnumerator<T> GetEnumerator()
    {
        // Implicitly calls first.GetEnumerator()
        foreach (T item in first)
        {
            yield return item;
        }
        // Implicitly calls second.GetEnumerator()
        foreach (T item in second)
        {
            yield return item;
        }
    }

    IEnumerator IEnumerable.GetEnumerator()
    {
        return GetEnumerator();
    }
}