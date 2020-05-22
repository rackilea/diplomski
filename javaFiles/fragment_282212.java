@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAppTests {

    @Autowired
    ConfigFile configFile;

    @Test
    public void contextLoads() {
        Assert.assertEquals(configFile.getVar1(), "aaa");
        Assert.assertEquals(configFile.getVar2(), "bbb");
        Assert.assertEquals(configFile.getVar3(), "ccc");
    }

}