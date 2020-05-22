@Override
public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

    if (oldExchange == null) {
        // the first time we aggregate we only have the new exchange,
        // so we just return it 
        return newExchange;
    }

    ...

    // return old
    return oldExchange;
}