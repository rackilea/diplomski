import java.util.Date;
import javax.smartcardio.*;

public class NewMethod {
    private long connectTime = -1;
    private long disconnectTime = -1;

    private TerminalFactory factory;
    private CardTerminals terminalList;
    private CardTerminal ct;

    public NewMethod() throws CardException{
        factory = TerminalFactory.getDefault();

        terminalList = factory.terminals();
        ct = terminalList.list().get(0);
    }

    public long waitForCardPresent(){
        try {
            ct.waitForCardPresent(0);
        } catch (CardException e) { }
        return new Date().getTime();
    }

    public long waitForCardAbsent(){
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e1) { }

            try{
                ct.connect("*").disconnect(false);
            }
            catch(Exception e) {
                return new Date().getTime();
            }
        }
    }

    public void run(){
        while(true){
            connectTime = waitForCardPresent();
            disconnectTime = waitForCardAbsent();
            System.out.println((disconnectTime-connectTime));
        }
    }

    public static void main(String[] args){
        NewMethod nm;
        try {
            nm = new NewMethod();
            nm.run();
        } catch (CardException e) {
            e.printStackTrace();
        }
    }
}