@Service
public class ReportService {

@Autowired
IGeneralDao reportDao, summaryDao;

public List<Response> call(EnumType type, RequestObject obj){
   IGeneralDao generalDao = isSummary ? summaryDao : reportDao;
   switch(type):
      case Category:
          return generalDao.reportOfCategory;
      case Group:
          return generalDao.reportOfGroup;
      case SubGroup:
          return generalDao.reportOfSubGroup;
...
}