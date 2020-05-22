@Override
public void finCoin(Money m) {
    if(m.getChange()%5==0){
      System.out.PrintLn("Return "+ m.getChange/5);
else {
    int remainngCoins=m.getChange()*((m.getChange/5)*5));
    m.setChange(remainngCoins);
    co.setnext(m);
}