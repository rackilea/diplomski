HashMap<String,Integer> jj=new HashMap<String, Integer>();
jj.put("A",10);
jj.put("B",20);
jj.put("c",30);
jj.put("Bd",50);
jj.put("Af",40);
jj.put("Bd",240);
jj.put("Ads",130);
jj.put("Bde",240);
jj.put("As",130);
jj.put("Bfe",210);
int threshold=100;
for(String key:jj.keySet()){
    String stock_item=key;
    Integer stock_value=jj.get(key);
    if(stock_value<threshold)
        System.out.println("Item:"+stock_item+" "+" Value:"+stock_value+"\n");
    }`