String youtubeLink = "http://youtube.com/watch?v=xxxx";

new YouTubeExtractor(this) {
@Override
public void onExtractionComplete(SparseArray<YtFile> ytFiles, VideoMeta vMeta) {
    if (ytFiles != null) {
        int itag = 22;
    String downloadUrl = ytFiles.get(itag).getUrl();
    }
}
}.extract(youtubeLink, true, true);