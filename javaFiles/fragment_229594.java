@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/*.xml")   
public class WsVehicleServiceTest {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    WsVehicleService wsVehicleService;

    @Test
    public void getHistoryAlarmInfo() throws Exception {
        try {
            String hi = wsVehicleService.sayHi();
            System.out.println(hi);
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}