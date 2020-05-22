@Controller
public class RevenueReportController extends AbstractController{

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ExcelRevenueReportView excelRevenueReportView;

    @Override
    @RequestMapping(value = "/search/exportToExcel", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String output = ServletRequestUtils.getStringParameter(request, "output");

        //dummy data
        Map<String,String> revenueData = new HashMap<String,String>();
        revenueData.put("Jan-2010", "$100,000,000");
        revenueData.put("Feb-2010", "$110,000,000");
        revenueData.put("Mar-2010", "$130,000,000");
        revenueData.put("Apr-2010", "$140,000,000");
        revenueData.put("May-2010", "$200,000,000");

        if(output ==null || "".equals(output)){
            //return normal view
            return new ModelAndView("RevenueSummary","revenueData",revenueData);

        }else if("EXCEL".equals(output.toUpperCase())){
            //return excel view
            new ModelAndView(excelRevenueReportView, "revenueData", revenueData);

        }else{
            //return normal view
            return new ModelAndView("RevenueSummary","revenueData",revenueData);

        }
    }
}