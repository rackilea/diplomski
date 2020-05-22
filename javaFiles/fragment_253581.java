@AggregateRoot
@Entity
@Table(name = "news")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class NewsAggregate extends AuditingAggregateRoot implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(NewsAggregate.class);


@Id
@Column(name = "news_id")
private String newsId;

@ManyToOne
@JoinColumn(name = "author_id", referencedColumnName = "id")
private UserAggregate authorId;

@Column(name = "publish_date")
private ZonedDateTime publishTime = null;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(
    name = "tags_news",
    joinColumns = {@JoinColumn(name = "news_id", referencedColumnName = "news_id")},
    inverseJoinColumns = {@JoinColumn(name = "tag", referencedColumnName = "tag")})
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
private Set<Tags> tags = new HashSet<Tags>();

@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
@JoinColumn(name = "news_id", referencedColumnName = "news_id")
@Fetch(FetchMode.JOIN)
private List<NewsTranslation> newsTranslation = new ArrayList<NewsTranslation>();

public NewsAggregate(Set<Tags> tags, UserAggregate authorId) {
    this.newsId = generateId(authorId.getId());
    this.tags = tags;
    this.authorId = authorId;
    this.publishTime = ZonedDateTime.now();
}

private NewsAggregate(Builder builder) {
    this.authorId = Preconditions.checkNotNull(builder.authorId);
    this.publishTime = builder.publishTime;
    this.tags = Preconditions.checkNotNull(builder.tags);
    this.newsTranslation = Preconditions.checkNotNull(builder.newsTranslation);
}

private String generateId(long userId) {
    return ZonedDateTime.now().toInstant().toEpochMilli() + "_" + userId;
}

public static NewsAggregate createNews(Set<Tags> tags, UserAggregate authorId, CreateNewsDto createNewsDto) {

    NewsAggregate news = new NewsAggregate(tags, authorId);
    log.info(">>>>>>>>>>>>>>>>>> news_id = "+news.getNewsId());
    NewsLangId newsLangId = new NewsLangId(news.getNewsId(), "en");

    NewsTranslation newsTranslation = new NewsTranslation(newsLangId, createNewsDto.getTitle(),
        createNewsDto.getShortDescription(), createNewsDto.getLongDescription());

    List<NewsTranslation> newsTranslations = new ArrayList<>();
    newsTranslations.add(newsTranslation);

    news.addTranslation(newsTranslations);
    return news;
}

private void addTranslation(List<NewsTranslation> newsTranslations) {
    this.newsTranslation = newsTranslations;
}