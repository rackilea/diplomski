public static Stream<ApplicationResponse> getApplications(String token, RestTemplate rt)
{
    return StreamSupport.stream(new AbstractSpliterator<ApplicationResponse[]>(Long.MAX_VALUE,
                                                                               Spliterator.ORDERED
                                                                                               | Spliterator.IMMUTABLE)
    {
        private int page = 1;

        @Override
        public boolean tryAdvance(Consumer<? super ApplicationResponse[]> action)
        {
            HttpEntity<String> entity = new HttpEntity<>("parameters", getHeaders(token));
            String url = String.format("%s?PageIndex=%s&PageSize=%s", endpoint, page, 500);
            ResponseEntity<ApplicationCollection> ar = rt.exchange(url, HttpMethod.GET, entity,
                                                                   ApplicationCollection.class);
            ApplicationResponse[] res = Objects.requireNonNull(ar.getBody()).getData();

            if (res.length == 0)
                return false;

            page++;
            action.accept(res);
            return true;
        }
    }, false).flatMap(Arrays::stream);
}