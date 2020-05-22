@Service
public class ReportService {

@Autowired
IGeneralDao reportDao, summaryDao;

public List<Response> call(EnumType type, RequestObject obj){
   IGeneralDao generalDao = isSummary ? summaryDao : reportDao;
   return generalDao.setEnumType(type).callReports(obj);
}