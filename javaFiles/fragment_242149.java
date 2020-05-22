import org.springframework.data.annotation.Id;

public class TeamDocument extends SolrDocument {

    @Id
    private String id;

    ...
}