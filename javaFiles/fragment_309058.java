public class OneToN2<K,V, CT extends Collection<V> > extends HashMap<K, Collection<V>>
{
    private final Supplier<CT> _containerCtor;

    /**
     * Create an instance.
     */
    public OneToN2( Supplier<CT> _containerCtor )
    {
        this._containerCtor = _containerCtor;
    }