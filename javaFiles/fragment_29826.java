public interface SourceStrategy{
    public Message getMessage();
}

public FtpLocation implements SourceStrategy{...}
public MessageQueue implements SourceStrategy{...}
public WebService implements SourceStrategy{...}

public class Application(){
    SourceStrategy s;
    public void setStrategy(SourceStrategy s){
        this.strategy = s;
    }
    public void readMessage(){
        Message m = this.s.getMessage();
    }
}