@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "test.xml", "spring.xml" })
public class Test {

    @Resource(name="beanSwappable")
    Bean b;

    @Resource(name = "beanSwap")
    HotSwappableTargetSource beanSwap;

    public void swap() {
        Bean b = << create mock version >>
        beanSwap.swap(b);
        // run test code which

    }
}