HashMap<String, String> param = new HashMap<String, String>();
    param.put("A", "2");
    param.put("B", "3");
    param.put("C", "2");
    int sum=0;
    for (Map.Entry<String, String> entry : param.entrySet()) {
        sum+=Integer.parseInt(entry.getValue());
    }
    String[] list = new String[sum];
    int i = 0;
    for (Map.Entry<String, String> entry : param.entrySet()) {
        int lim=Integer.parseInt(entry.getValue());
       for(int j=0;j<lim;j++){
          list[i]=entry.getKey()+" "+String.valueOf(j+1);
           i++;
       }
    }