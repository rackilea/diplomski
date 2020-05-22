dataArray.parallelStream().forEach(e->{
        JSONObject temp = (JSONObject) dataArray.get(iter);
        System.out.println(temp.get("symbol"));
        //getQuote function has network calls. 
        //Serial implementation makes it take too much time
        if (some condition here) {
           throw new YourException("Your exception messge");
         }
        topGainers.add(this.getQuote((String)temp.get("symbol")));
    });