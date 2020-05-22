class Sender {
    UnicastProcessor<> outgoing = ...
    UnicastPorcessor<> incoming = ...

    Map<String, MonoSink> monoSinksMap = ...;
    Map<String, FluxSink> fluxSinksMap = ...;

    public Sender () {