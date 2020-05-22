Abdera abdera = new Abdera();
    Parser parser = abdera.getParser();

    URL url = new URL(
            "http://self-learning-java-tutorial.blogspot.in/atom.xml");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestProperty("Accept-Encoding", "gzip");
    conn.connect();

    try {
        String contentEncoding = conn.getContentEncoding();
        boolean isGzip = contentEncoding != null
                && contentEncoding.contains("gzip");
        try (InputStream in = !isGzip ? conn.getInputStream()
                : new GZIPInputStream(conn.getInputStream())) {
            Document<Feed> doc = parser.parse(in, url.toString());
            Feed feed = doc.getRoot();
            System.out.println(feed.getTitle());
            for (Entry entry : feed.getEntries()) {
                System.out.println("\t" + entry.getTitle());
            }
            System.out.println(feed.getAuthor());
        }
    } finally {
        conn.disconnect();
    }