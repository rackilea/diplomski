public String url;

public ThreadsTest(String url) {
    this.url = url;
}

public String call() throws Exception {
    HttpURLConnection connection = (HttpURLConnection) new URL("http://"
            + url).openConnection();
    connection.setInstanceFollowRedirects(false);
    connection.setRequestProperty("User-Agent",
            "Mozilla/5.0 (compatible; MSIE 5.01; Windows NT 5.0)");
    connection.setRequestProperty("Referer", "http://www.google.co.uk");
    connection.setConnectTimeout(30000);
    connection.setReadTimeout(30000);

    String content = "";
    if (connection.getResponseCode() == 200) {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            content += inputLine;
        in.close();
        System.out.println(url + " returned "
                + connection.getResponseCode() + " response code");
    } else {
        System.err.println(url + " returned "
                + connection.getResponseCode() + " response code");
    }

    return content;
}

public static void main(String[] args) throws Exception {

    String[] sites = { "courseassignment.com", "errocks.com",
            "villsoft.com", "miraclegarciniacambogiarx.net",
            "www.mcqplay.com", "www.ajnad-sham.com", "bstore.in",
            "rajestateagency.in", "royalboutique.in", "www.masiada.com",
            "awebstreet.com", "adbfc.com", "starhairforum.com",
            "akflix.com", "planetskool.com", "sceteducation.org",
            "www.smarts3i.com", "www.my.aybhost.com",
            "www.svmconstructions.in", "www.nssj.co.in" };

    System.out.println(sites.length);

    ExecutorService service = Executors.newCachedThreadPool();
    List<Future<String>> futures = new ArrayList<Future<String>>();

    for (int i = 0; i < sites.length; i++) {

        Future<String> future = service.submit(new ThreadsTest(sites[i]));
        futures.add(future);

    }

    for (Future<String> future : futures) {
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    service.shutdown();
    if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
        // Timed Out waiting to finish, so force a shutdown
        service.shutdownNow();
    }
}