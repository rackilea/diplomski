@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy ({
  @ContextConfiguration("/META-INF/spring/applicationContext.xml"),
  @ContextConfiguration("file:src/main/webapp/WEB-INF/spring/webmvc-config.xml")
})
public abstract class AbstractContextControllerTests {

    @Autowired
    protected WebApplicationContext wac;

}