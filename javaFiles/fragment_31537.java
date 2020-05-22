List<FaAccountBalance> aggr = new ArrayList<>();
HashMap<String,Integer> map = new HashMap<>();
for(FaAccount account : accounts){
        String currency = account.getCurrency();
        int balance =account.getBalance();
        FaAccountBalance ag = new FaAccountBalance();
        ag.setCurrency(currency);
        ag.setBalance(balance);
        aggr.add(ag);        
        map.put(currency,map.getOrDefault(currency,0) + balance);
}