@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public abstract class AbstractContextTest {
  @Configuration
  @ComponentScan(basePackages = "my.package.name.test",
                 includeFilters = @Filter(type = FilterType.ANNOTATION,
                                          value = Configuration.class))
  static class ContextConfiguration {}
}