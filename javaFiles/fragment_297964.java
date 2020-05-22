public class Downloader extends Task<List<Article>> {

    private final List<Channel> channels ;

    public Downloader(List<Channel> channels) {
        this.channels = channels ;
    }

    @Override
    public List<Article> call() throws Exception {
        return channels.parallelStream()
            .flatMap(channel -> getRssList(channel).parallelStream())
            .flatMap(rss -> getHtmlList(rss).stream())
            .collect(Collectors.toList());
    }

    private List<Article> getRssList(Channel channel) {
        // this runs in its own thread, return List<Article> for given channel
    }

    private List<Article> getHtmlList(Article rss) {
        // this runs in its own thread, return List<Article> for given rss
    }
}