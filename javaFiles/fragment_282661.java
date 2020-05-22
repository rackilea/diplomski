Document document = Jsoup.connect("http://www.craigslist.org/about/sites").get();
Elements countries = document.select("div.colmask");

for (Element country : countries) {
    System.out.println("Country: " + country.select("h1.continent_header").text());
    Elements states = country.select("div.state_delimiter");

    for (Element state : states) {
        System.out.println("\tState: " + state.text());
        Elements cities = state.nextElementSibling().select("li");

        for (Element city : cities) {
            System.out.println("\t\tCity: " + city.text());
        }
    }
}