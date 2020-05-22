/**
 * Sets video path.
 *
 * @param path the path of the video.
 */
public void setVideoPath(String path) {
    setVideoURI(Uri.parse(path));
}
/**
 * Sets video URI.
 *
 * @param uri the URI of the video.
 */
public void setVideoURI(Uri uri) {
    setVideoURI(uri, null);
}