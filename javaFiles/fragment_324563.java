package sp;

import com.ib.client.Contract;
import com.ib.client.EClientSocket;
import com.ib.client.EWrapper;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SP {
    //just a sample, like this so you can just use Files.lines instead.
    private static List<String> lines = Arrays.asList(new String[]{
        "Symbol,Name,Sector",
        "MMM,3M Company,Industrials",
        "ABT,Abbott Laboratories,Health Care",
        "ABBV,AbbVie,Health Care",
        "ACN,Accenture plc,Information Technology",
        "ATVI,Activision Blizzard,Information Technology",
        "AYI,Acuity Brands Inc,Industrials",
        "ADBE,Adobe Systems Inc,Information Technology",
        "AAP,Advance Auto Parts,Consumer Discretionary",
        "AES,AES Corp,Utilities",
        "AET,Aetna Inc,Health Care",
        "AMG,Affiliated Managers Group Inc,Financials",
        "AFL,AFLAC Inc,Financials",
        "A,Agilent Technologies Inc,Health Care",
        "APD,Air Products & Chemicals Inc,Materials",
        "AKAM,Akamai Technologies Inc,Information Technology",
    });


    public static void main(String[] args) throws InterruptedException{
        EWrapper wrapper = new  Wrapper();
        EClientSocket socket = new EClientSocket(wrapper);
        socket.eConnect("", 4001, 123);
        //supposedly gives frozen last recorded value, not working!
        socket.reqMarketDataType(2);

        AtomicInteger tickerId = new AtomicInteger(0);
        lines.stream().skip(1).forEach(line -> {
            //new cont for every request
            Contract cont = new Contract();
            cont.m_currency = "usd";
            cont.m_exchange = "smart";
            cont.m_secType = "stk";
            cont.m_symbol = line.split(",")[0];
            Data data = new Data(cont, socket);
        });

        //need you own logic for when to end program
        //Thread.sleep(5000);//this thread, Socket starts a reader thread
        //socket.eDisconnect();
    }
}