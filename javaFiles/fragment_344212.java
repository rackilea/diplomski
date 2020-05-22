@Value("${value}")
private int expire;
private LoadingCache<Integer, ConcurrentHashMap<Point, Boolean>> loadingCache;


    @PostConstruct
    public void init() {
        loadingCache = CacheBuilder.newBuilder()
                .maximumSize(5000)
                .expireAfterAccess(expire, TimeUnit.SECONDS)
                .build(new CacheLoader<Integer, ConcurrentHashMap<Point, Boolean>>() {
                    @Override
                    public ConcurrentHashMap<Point, Boolean> load(Integer key)   {
                        return new ConcurrentHashMap<>(2500);
                    }
                });
    }