@Path("")
@Controller
public class ServiciosAuraPortalRESTfulService {

    @Autowired
    @Qualifier("ServiceA")
    private ServiceAura srvA;

    @Autowired
    @Qualifier("ServiceB")
    private ServiceAura srvB;