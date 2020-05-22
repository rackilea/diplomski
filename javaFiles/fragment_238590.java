@Component
public class CrawlerClient{
    private Properties crawlerProperties;
    private final Integer maxTopic;

    @Autowired
    public CrawlerClient(@Qualifier("crawlerProperties") Properties crawlerProperties,
         @Value("maxTopic") Integer maxTopic){
        this.crawlerProperties = crawlerProperties;
        this.maxTopic = maxTopic;

        List<Topic> topics = topicBusiness.getAll();
        List<Blogger> bloggers = bloggerBusiness.getAll();
        List<Clue> clues = clueBusiness.getAll();
        ClueQueue.addAll(clues);
        TopicQueue.addAll(topics);
        BloggerQueue.addAll(bloggers);
    }
..
}