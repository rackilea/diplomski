import myapp.org.apache.http.client.cache.HttpCacheEntry;
import myapp.org.apache.http.client.cache.HttpCacheUpdateCallback;
import myapp.org.apache.http.impl.client.cache.CacheConfig;
import myapp.org.apache.http.impl.client.cache.ManagedHttpCacheStorage;

public class FileCacheStorage extends ManagedHttpCacheStorage {

    private File mCacheDir;

    public FileCacheStorage(final CacheConfig config, File cacheDir) {
        super(config);
        mCacheDir = cacheDir;
    }

    @Override
    public HttpCacheEntry getEntry(final String url) throws IOException {
        HttpCacheEntry entry = super.getEntry(url);
        if (entry == null) {
            entry = loadCacheEnrty(url);
        }
        return entry;
    }

    @Override
    public void putEntry(final String url, final HttpCacheEntry entry) throws IOException {
        super.putEntry(url, entry);
        saveCacheEntry(url, entry);
    }

    @Override
    public void removeEntry(final String url) throws IOException {
        super.removeEntry(url);
        File cache = getCacheFile(url);
        if (cache != null && cache.exists()) {
            cache.delete();
        }
    }

    @Override
    public void updateEntry(
            final String url,
            final HttpCacheUpdateCallback callback) throws IOException {
        super.updateEntry(url, callback);
        HttpCacheEntry entry = loadCacheEnrty(url);
        if (entry != null) {
            callback.update(entry);
        }
    }

    private void saveCacheEntry(String url, HttpCacheEntry entry) {
        ObjectOutputStream stream = null;
        try {
            File cache = getCacheFile(url);
            stream = new ObjectOutputStream(new FileOutputStream(cache));
            stream.writeObject(entry);
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HttpCacheEntry loadCacheEnrty(String url) {
        HttpCacheEntry entry = null;
        File cache = getCacheFile(url);
        if (cache != null && cache.exists()) {
            synchronized (this) {
                ObjectInputStream stream = null;
                try {
                    stream = new ObjectInputStream(new FileInputStream(cache));
                    entry = (HttpCacheEntry) stream.readObject();
                    stream.close();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (StreamCorruptedException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return entry;
    }

    private File getCacheFile(String url) {
        return new File(mCacheDir, MD5.getHash(url));
    }

}