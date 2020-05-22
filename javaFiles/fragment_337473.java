public class ResponseIterator
    implements Iterator<Stream<ApplicationResponse>>
{
    private int                   page = 1;
    private String                token;
    private RestTemplate          rt;

    private ApplicationResponse[] next;

    private ResponseIterator(String token, RestTemplate rt)
    {
        this.token = token;
        this.rt = rt;
    }

    public static Stream<ApplicationResponse> getApplications(String token, RestTemplate rt)
    {
        Iterable<Stream<ApplicationResponse>> iterable = () -> new ResponseIterator(token, rt);
        return StreamSupport.stream(iterable.spliterator(), false).flatMap(Function.identity());
    }

    @Override
    public boolean hasNext()
    {
        if (next == null)
        {
            next = getNext();
        }
        return next.length != 0;
    }

    @Override
    public Stream<ApplicationResponse> next()
    {
        if (next == null)
        {
            next = getNext();
        }
        Stream<ApplicationResponse> nextStream = Arrays.stream(next);
        next = getNext();
        return nextStream;
    }

    private ApplicationResponse[] getNext()
    {
        HttpEntity<String> entity = new HttpEntity<>("parameters", getHeaders(token));
        String url = String.format("%s?PageIndex=%s&PageSize=%s", endpoint, page, 500);
        ResponseEntity<ApplicationCollection> ar = rt.exchange(url, HttpMethod.GET, entity,
                                                               ApplicationCollection.class);
        ApplicationResponse[] res = Objects.requireNonNull(ar.getBody()).getData();
        page++;
        return res;
    }
}