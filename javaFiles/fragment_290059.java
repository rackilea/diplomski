public class CompositeKeyBasedCreditCardDetailsHolder<K, V> extends
AbstractBankCardDetailsHolder<K, V> {

    private CompositeKeyImplementer<? extends K, ? extends K> numberProviderPair;

    // ....... TBC

}