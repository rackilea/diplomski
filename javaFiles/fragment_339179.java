import com.ib.client.*;
import com.ib.contracts.StkContract;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class Test implements EWrapper {
    EJavaSignal m_signal = new EJavaSignal();
    EClientSocket m_client = new EClientSocket(this, m_signal);

    private int nextOrderID = 0;
    private double high = Double.MAX_VALUE;
    private double low = -Double.MAX_VALUE;

    public static void main(String[] args) {
        new Test.run();
    }

    private void run() {
        m_client.eConnect("localhost", 7497, 123);
        final EReader reader = new EReader(m_client, m_signal);
        reader.start();
        new Thread() {
            @Override
            public void run() {
                while (m_client.isConnected()) {
                    m_signal.waitForSignal();
                    try {
                        reader.processMsgs();
                    } catch (Exception e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Override
    public void nextValidId(int orderId) {
        System.out.println("id "+orderId);
        nextOrderID = orderId;
        Contract c = new StkContract("IBKR");
        m_client.reqHistoricalData(1, c, 
                LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)+ " 16:00:00",
                "2 D", "1 day", "TRADES", 1, 1, null);
        m_client.reqMktData(1, c, "", false, null);
    }

    @Override
    public void error(int id, int errorCode, String errorMsg) {
        System.out.println(id + " " + errorCode + " " + errorMsg);
    }

    @Override
    public void historicalData(int reqId, String date, double open, double high, double low, double close, int volume, int count, double WAP, boolean hasGaps) {
        //if being run on the next calendar day, this works
        if (LocalDate.now().minusDays(1).format(DateTimeFormatter.BASIC_ISO_DATE).equals(date)){
            this.high = high;
            this.low = low;
            System.out.println(date + " h: " + high + " l: " +low);
        }
    }

    @Override
        public void tickPrice(int tickerId, int field, double price, int canAutoExecute) {

        System.out.println("id: "+tickerId + " " + TickType.getField(field) + " price: "+price);
        if (field == TickType.LAST.index()){
            if (price > high) {
                System.out.println("buy");
            }
            if (price < low){
                System.out.println("sell");
            }
        }

    }
 //impl rest of EWrapper
}