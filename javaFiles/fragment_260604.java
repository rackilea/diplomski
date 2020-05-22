@Controller
public class YourContrller {

    @Autowired
    @Resource(name="${reportService}")
    private ReportService reportService;

    public Report generate() {

        return reportService.generate();
    }
}

@Service("ReportService_1")//name this service as ReportService_1
public class ReportService_1Impl implements ReportService {
  //actual code
}

@Service("ReportService_2")//name this service as ReportService_2
public class ReportService_2Impl implements ReportService {
  //actual code
}