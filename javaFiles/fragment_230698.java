import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.jws.WebService;
import javax.jws.WebParam;
import javax.ejb.Stateless;

@WebService(serviceName = "soco.ws.bb.bearBearWS")
@Singleton
//@Stateless
public class BearBearImpl implements BearBearWS {

    int state = 0;
    static int staticState = 0;
    @EJB StateBean sb = new StateBean();

    @Override
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @Override
    public void setAllState(int in) {
        System.out.println("setting instance state from "+state+" to "+in);
        state = in; 
        System.out.println("setting static state from "+staticState+" to "+in);
        staticState = in; 
        System.out.println("setting singleton state from "+sb.state+" to "+in);
        sb.state = in;
    }

    @Override
    public int getInstanceState() { 
        System.out.println("returning instance state "+state);
        return state; 
    }

    @Override
    public int getStaticState() { 
        System.out.println("returning static state "+staticState);
        return staticState; 
    }

    @Override
    public int getSingletonState() { 
        System.out.println("returning singleton state "+sb.state);
        return sb.state; 
    }
}