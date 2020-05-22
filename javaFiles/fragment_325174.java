@Override
public int finCoin(Money m) {   // VERY IMPORTANT replace void by int
    if(m.getChange()%5==0){
      // System.out.PrintLn("Return "+ m.getChange/5);
      return m.getChange/5;   // thats how you return a value and end this method call
    else {
      int remainngCoins=m.getChange()*((m.getChange/5)*5));
      m.setChange(remainngCoins);
      co.setnext(m);
    }
    return 0;   // this is just a guess but you MUST return something
}