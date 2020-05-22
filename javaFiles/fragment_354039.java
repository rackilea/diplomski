@Autowired 
private Environment environment;

public String getUrl(String year) {

    String url = "url." + year ;

    String value =environment.getProperty(url);

    return url;
}