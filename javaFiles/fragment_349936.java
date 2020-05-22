import java.util.Calendar;

//class representing all your data
public class StockData implements Comparable<StockData>{
    private int id;
    private Calendar date;
    private List<ShareBean> shares;

//this will return whichever StockData that has more total shares as being greater
@Override
public int compareTo(StockData arg0) {
    int totalshares = 0;
    int totalshares2 = 0;
    for(ShareBean share: shares)
        totalshares+=share.getShares();
    for(ShareBean share: arg0.getShares())
        totalshares2+=share.getShares();
    return totalshares-totalshares2;
}
    //this method is used to see if another StockData object has the same id
    @Override
    public boolean equals(Object arg0) {
        try {
        StockData arg1 = (StockData) arg0;
        if (id == arg1.id)
            return true;
        } catch (Exception e) {
        return false;
    }
    return false;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
    public Calendar getDate() {
    return date;
    }
    public void setId(int id) {
    this.id = id;
        }
        public int getId() {
            return id;
    }


    public void setShares(List<ShareBean> shares) {
    this.shares = shares;
    }

    public List<ShareBean> getShares() {
    return shares;
    }

public String toString(){
    String toReturn = "";
    toReturn+="ID: "+id+"\n";
    toReturn+="Date: "+date.getTime()+"\n";
    for(ShareBean share: shares)
        toReturn+="Shares: "+share.toString()+"\n";
    return toReturn;
}
}