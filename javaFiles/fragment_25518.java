for (int i = 0; i < tickList.length; i++) {
    Ticket t = tickList[i];
    //use t in this scope
    //in this case, it's used to accumulate the value of total
    total += t.getPrice();
}