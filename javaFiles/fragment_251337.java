class Dog {
    private final String color;
    private final Photo photo;

    public Dog(final String color, final Photo photo) {
        this.color = color;
        this.photo = photo;
    }
}

class Photo {

    private final Resource resource;

    public Photo(final String path) throws MalformedURLException {
        this.resource = new UrlResource(path);
    }

    public String getUrl() {
        return resource.getUrl();
    }

    public Bitmap getBitmap() {
        final InputStream is = resource.getInputStream();
        // transform is to Bitmap
        // cache the result
        return bitmap;
    }

}

class UrlResource implements Resource {
    private final URL url;

    public UrlResource(final String path) throws MalformedURLException {
        Assert.notNull(path, "Path must not be null");
        this.url = new URL(path);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        final URLConnection con = this.url.openConnection();
        con.setUseCaches(false);
        try {
            return con.getInputStream();
        } catch (final IOException ex) {
            // Close the HTTP connection (if applicable).
            if (con instanceof HttpURLConnection) {
                ((HttpURLConnection) con).disconnect();
            }
            throw ex;
        }
    }

    @Override
    public String getUrl() {
        return url.toString();
    }
}

interface Resource {
    InputStream getInputStream() throws IOException;

    String getUrl();
}


// Multi thread approach.... just the idea... it won't compile
interface AsyncResource extends Resource {
    Future<Data> getData();       
}

// On Photo
public Photo(final AsyncResource resource) {
    this.resource = resource;
}

public Bitmap getBitmap() {
    final Future<Data> data = resource.getData();
     // call data.get(), Hopefully won't block
    // transform is to Bitmap
    // cache the result
    return bitmap;
}

class AsyncResourceProvider {
  final ExecutorService threadExecutor = Executors.newFixedThreadPool(10);

  AsyncResource schedule(String path) {
    // submit the taks and return the future
  }

}
// Create a Dog and a Photo
AsyncResource resource = asyncResourceProvider.schedule(path);
Dog d = new Doc("black", new Photo(resource));