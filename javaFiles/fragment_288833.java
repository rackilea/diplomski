@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationcontext-Service.xml","applicationcontext-Hibernate.xml","applicationContext-dao.xml"})
public class BookingProcessServiceTest {

    @Autowired
    private BookingProcessService bookingProcessService;

}