CopyOnWriteArrayList<StockQuote> topGainers = new CopyOnWriteArrayList<>();
    dataArray.parallelStream().forEach(e->{
        JSONObject temp = (JSONObject) dataArray.get(iter);
        System.out.println(temp.get("symbol"));
        //getQuote function has network calls. 
        //Serial implementation makes it take too much time
        topGainers.add(this.getQuote((String)temp.get("symbol")));
    });