@Configuration
@ConfigurationProperties(prefix = "props")
public class TagIncluder {
    private List<String> tags;

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }
}

@Component
public class MyComponent {
    @Autowired
    TagIncluder tagIncluder;
}

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@SpringBootTest
@ActiveProfiles("tag_test")
@RunWith(SpringRunner.class)
public class TagIncluderTest {

    @Autowired
    private TagIncluder sut;

    @Test
    public void attachIncludedTags_shouldUseTagsInFileIfFileSpecified() {
        System.out.println(sut.getTags());
    }
}