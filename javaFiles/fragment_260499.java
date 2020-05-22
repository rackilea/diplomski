@Controller  
public class LoginController {  

     @Autowired
      private NextShipmentDao nextShipmentDao;

       public void setNextShipmentDao(NextShipmentDao nextShipmentDao) {
        this.nextShipmentDao = nextShipmentDao;
     }