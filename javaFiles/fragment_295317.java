package my.package;
import javax.jws.WebService;
@WebService
public class Red5WS{
    MyApplication app = null;
    public Game(){
        /* Needed but it can be empty */
    }
    public Game(MyApplication app){
        this.app = app;
    }
    public String getAttribute(String SOname, String attrName){
        ISharedObject so = app.getSharedObject(this.app.getScope(), SOname,true);
        return so.getAttribute(attrName);
    }
}