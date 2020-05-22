public class DAOFactory {
  private static IDAO dao = null;
  public static IDAO getDAOInstance(TypeDAO type){
    if((type == TypeDAO.MySQL)&&(dao == null))dao = new MySQLDAO();   
    return dao;
  }
}