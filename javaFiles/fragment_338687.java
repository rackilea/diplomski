import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
    public static void main(String[] args) throws Exception {
        Root root = new ObjectMapper().readValue(Input.json, Root.class);
        CSVPrinter printer = CSVFormat.DEFAULT
                                      .withHeader("Name", "Author", "Address", "Service", "Link")
                                      .print(System.out);
        for (Site site : root.getSites())
            for (Service service : site.getServices())
                printer.printRecord(site.getName(), site.getAuthor(), site.getAddress(),
                                    service.getService(), service.getLink());
    }
}
class Root {
    private List<Site> sites;

    @JsonProperty("Yjson")
    public List<Site> getSites() {
        return this.sites;
    }
    public void setSites(List<Site> sites) {
        this.sites = sites;
    }
}
class Site {
    private String        name;
    private String        author;
    private String        address;
    private List<Service> services;

    @JsonProperty("Name")
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Author")
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("Address")
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("Company Services")
    public List<Service> getServices() {
        return this.services;
    }
    public void setServices(List<Service> services) {
        this.services = services;
    }
}
class Service {
    private String service;
    private String link;

    @JsonProperty("Service")
    public String getService() {
        return this.service;
    }
    public void setService(String service) {
        this.service = service;
    }

    @JsonProperty("Link")
    public String getLink() {
        return this.link;
    }
    public void setLink(String link) {
        this.link = link;
    }
}
class Input {
    static final String json =
        "{\"Yjson\":\n" +
        "[\n" +
        "{\n" +
        "\"Name\": \"crunchify.com\",\n" +
        "    \"Author\": \"App Shah\",\n" +
        "    \"Address\": \"New York\",\n" +
        "    \"Company Services\": [{\n" +
        "        \"Service\": \"Site SEO Review\",\n" +
        "        \"Link\": \"https://crunchify.com/services/site-seo-review-service/\"\n" +
        "    }, {\n" +
        "        \"Service\": \"Full Website Design Service\",\n" +
        "        \"Link\": \"https://crunchify.com/services/full-website-design-service/\"\n" +
        "    }, {\n" +
        "        \"Service\": \"WordPress Optimization & Consultation\",\n" +
        "        \"Link\": \"https://crunchify.com/services/wordpress-optimization-service/\"\n" +
        "    }, {\n" +
        "        \"Service\": \"WordPress Optimization & Consultation\",\n" +
        "        \"Link\": \"https://crunchify.com/services/wordpress-optimization-service/\"\n" +
        "    }]\n" +
        "},\n" +
        "{\n" +
        "    \"Name\": \"xyz.com\",\n" +
        "    \"Author\": \"xyz Shah\",\n" +
        "    \"Address\": \"toronto\",\n" +
        "    \"Company Services\": [{\n" +
        "        \"Service\": \"Site SEO Review\",\n" +
        "        \"Link\": \"https://crunchify.com/services/site-seo-review-service/\"\n" +
        "    }, {\n" +
        "        \"Service\": \"Full Website Design Service\",\n" +
        "        \"Link\": \"https://crunchify.com/services/full-website-design-service/\"\n" +
        "    }, {\n" +
        "        \"Service\": \"WordPress Optimization & Consultation\",\n" +
        "        \"Link\": \"https://crunchify.com/services/wordpress-optimization-service/\"\n" +
        "    }]\n" +
        "}\n" +
        "]\n" +
        "}";
}