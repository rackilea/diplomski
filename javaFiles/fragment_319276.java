@Component
public class Helper {

  @Autowired
  private IDao dao;

  public PropertyValue getProperty(String objId, String propId) {
    obj = dao.getObj(objId);
    if(obj == null)
      return null;
    if(some other condition)
      log result
    return obj.getProperty(propId)
  } // getProperty
} // class Helper