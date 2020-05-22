public class NewsService extends AbstractService<News, NewsRepository> {
    @Inject private NewsRepository newsRepository;

    @Override
    public NewsRepository getRepository() {
        return newsRepository;
    }

    // the inherited add() method works now
}