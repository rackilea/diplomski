ListIterator<Bet> i = table.bets.listIterator();
Iterator<Outcome> b = bin.outcomes.iterator();

while(i.hasNext()) {
  Bet bet = i.next();
  System.out.println(bet.outcome.name.toString());
  while(b.hasNext()){
    Outcome o = b.next();
    System.out.println(o.name.toString());

    if(bet.outcome.equals(o)){
      System.out.println("Win!");
    } else {
      System.out.println("Win :/");
    }
}