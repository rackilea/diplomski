Map<String,Integer> countMap = new HashMap<String,Integer>();
while ((thisLine = inputStream.readLine()) != null) {
        l = thisLine.substring(1, 18);

        if(countMap.containsKey(l)){
              countMap.put(l, countMap.get(l)+1);
        }else{
          countMap.put(l,1);
       }
    }