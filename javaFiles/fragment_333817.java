HashMap<String, String> param = new HashMap<String, String>();
    param.put("A", "2");
    param.put("B", "3");
    param.put("C", "2");

    String[] list = new String[7];// It is better to use List other than an array
    int i = 0;
    for (Map.Entry<String, String> entry : param.entrySet()) {
        int lim=Integer.parseInt(entry.getValue());
       for(int j=0;j<lim;j++){
          list[i]=entry.getKey()+" "+String.valueOf(j+1);
           i++;
       }
    }