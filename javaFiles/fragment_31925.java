@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ZonesTest
{
    @Autowire
    Zones zones;

    // your BeforeClass method here

    @Test
    public void testCountDBRowNum() throws Exception
    {
        int rows = zones.countDBRowNum();

        System.out.println(rows);

    }