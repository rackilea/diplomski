public ShareBean(String ticker, int shares){
    this.ticker = ticker;
    this.shares = shares;
}

public void setTicker(String ticker) {
    this.ticker = ticker;
}
public String getTicker() {
    return ticker;
}
public void setShares(int shares) {
    this.shares = shares;
}
public int getShares() {
    return shares;
}


public String toString(){
    String toReturn = "";
    toReturn+="Ticker: "+ticker+", Shares: "+shares;
    return toReturn;
}
}