Iterator<Entry<Long, String>> it = 
   yourMap.entrySet().iterator();
    while (it.hasNext()) {
    Map.Entry<Long, String> pairs = (Map.Entry<Long, String>) it.next();
        bw.write(pairs.getValue());
    }