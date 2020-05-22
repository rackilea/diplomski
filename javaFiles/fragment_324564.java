package sp;

import com.ib.client.CommissionReport;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.ib.client.EWrapper;
import com.ib.client.Execution;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.TickType;
import com.ib.client.UnderComp;
import java.util.HashMap;
import java.util.Map;

public class Wrapper  implements EWrapper{
    public Map<Integer, Data> dataMap = new HashMap<>();
    public Map<Integer, Strat> orderMap = new HashMap<>();

    //reqMktData snapshots are received here
    @Override
    public void tickPrice(int tickerId, int field, double price, int canAutoExecute) {
        if (field == TickType.LAST) {
            //if you just want the last price
            dataMap.get(tickerId).dataRecd(price);
        }
    } 

    @Override
    public void execDetails(int reqId, Contract contract, Execution execution) {
        orderMap.get(execution.m_orderId).exec(execution);
    }
//snip
}