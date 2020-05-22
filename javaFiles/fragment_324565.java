package sp;

import com.ib.client.Contract;
import com.ib.client.EClientSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Data {
            final Contract cont;
    private final EClientSocket socket;
    private final Strat strat;

    private static int nextId = 1; //auto increment for each request
    private final int myId;

    List<Double> prices = new ArrayList<>();
    double lastPrice = -1;

    public Data(Contract cont, EClientSocket socket) {
        this.cont = cont;
        this.socket = socket;
        strat = new Strat(this, socket);
        myId = nextId++;
        ((Wrapper) socket.wrapper()).dataMap.put(myId, this);
        reqData();
//        //call every 10 min
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                reqData();
//            }
//        }, 10 * 60 * 1000);
    }

    private void reqData(){
        socket.reqMktData(myId, cont, "", false /* true */, null);
    }

    public void dataRecd(double last){
        lastPrice = last;
        prices.add(last);
        strat.check();
    }
}