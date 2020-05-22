@Controller
@RequestMapping(value = "clause")
public class ClauseController {

  @RequestMapping(value="getUpdate") 
  @ResponseBody
  public String selectClause(ModelMap model) {
  DbManager dbManager = DAO.getDbManager;     
    return "dbManager.latitude";
  }
}