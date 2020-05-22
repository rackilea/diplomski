@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "/package/where/your/xml/config/files/are/located/spring-config.xml"
    })
public class FooTest {
    //now Spring handles its creation and bean injection
    @Autowired
    AClass aClass;

    public void foo() {
        aClass.doAThing();
        //further code for your test...
    }
}