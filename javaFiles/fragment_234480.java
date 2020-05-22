public static void main(String[] args) {
    String googleAJAX = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
    String searchFor = "stuff";

    /**
        **Edit:** of course you can also get user input as a string
        and search for that instead. i.e.:
        String searchFor = (new Scanner(System.in)).nextLine();
    **/        

    URL url = new URL(googleAJAX + URLEncoder.encode(searchFor, "UTF-8"));
    Reader read = new InputStreamReader(url.openStream(), "UTF-8");
    GoogleResults results = new Gson().fromJson(read, GoogleResults.class);

    // Return results (title and URL)
    System.out.println(results.getResponseData().getResults().get(0).getTitle());
    System.out.println(results.getResponseData().getResults().get(0).getUrl());
}