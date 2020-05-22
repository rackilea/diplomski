package sp;

import com.ib.client.EClientSocket;
import com.ib.client.Execution;

public class Strat {
    public static final int NULL=0, LOOK=1<<0, LONG=1<<1, SHORT=1<<2, WAIT_FILL=1<<3, WAIT_CANCEL=1<<4;
    public int sysState = NULL;
    private final Data data;
    private final EClientSocket socket;

    private static int nextOrderId = 1;

    Strat(Data data, EClientSocket socket) {
        this.data = data;
        this.socket = socket;
        sysState = LOOK;
    }

    void check() {
        System.out.println("should I buy? "+ data.cont.m_symbol + " @ " + data.lastPrice);
        /*if (false && sysState & LOOK == LOOK) {
            ((Wrapper) socket.wrapper()).orderMap.put(nextOrderId, this);
            socket.placeOrder(nextOrderId++, data.cont, new Order());
            sysState = WAIT_FILL;
            nextOrderId++;
        }*/
    }

    public void exec(Execution exec){
        //will be called by wrapper after an exec.
        //sysState = LONG; //or whatever
    }
}