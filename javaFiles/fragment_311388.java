@ExtendWith(SpringExtension.class) // assumes Junit 5
@ContextConfiguration(classes = BeanConfiguration.class)
public class ExcludeConditionTest {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private BeanExcluded beanExcluded;
    @ExcludeBeanByQualifierForCollectionAutowired(qualifierToExcludeValue = "excludedBean" , aClass = ParentBean.class)
    private List<ParentBean> beensWithoutExclude;

    @Test
    void should_not_inject_excluded_bean() {
        assertThat(context.getBeansOfType(ParentBean.class).values())
                .hasOnlyElementsOfTypes(Bean1Included.class,
                                        Bean2Included.class,
                                        Bean3Included.class,
                                        BeanExcluded.class);

        assertThat(beansWithoutExclude)
                .hasOnlyElementsOfTypes(Bean1Included.class,
                                        Bean2Included.class,
                                        Bean3Included.class)
                .doesNotHaveAnyElementsOfTypes(BeanExcluded.class);

        assertThat(beanExcluded).isNotNull();
    }
}