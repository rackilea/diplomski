@WebService(serviceName="backend")
@Stateless
public class backEndForm implements backEndFormRemote {

    @EJB
    private datatypesRemote data;

    public List<Datatype> retrieveAllDatatypes(int id){      
        return  data.retrieveAllDatatypes(id,null);
    }
}