private <T extends IOrder> T getOrder( List<T> orders, String gcsId )
{
    Predicate<T> predicate = c -> c.getGcsId().equals( gcsId );
    T obj = orders.stream().filter( predicate ).findFirst().get();
    return obj;
}