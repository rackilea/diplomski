@Service
public class LoginServiceImpl implements LoginService {

    @PersistenceContext
    private EntityManager entityManager;

    public Boolean checkUsernameAndPassword(String username, String password) {

        //"login" this is the name of your procedure
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("login"); 

        //Declare the parameters in the same order
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);

        //Pass the parameter values
        query.setParameter(1, username);
        query.setParameter(2, password);

        //Execute query
        query.execute();

        //Get output parameters
        Integer outCode = (Integer) query.getOutputParameterValue(3);
        String outMessage = (String) query.getOutputParameterValue(4);

        return true; //enter your condition
    }
}