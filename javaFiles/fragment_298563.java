synchronized(map){                       // <-- is it necessary?
            if(/*condition*/){
                log(map.size());
                for(List<String> value: map.values(){
                    log(id, value);
                }
            }
            else{
                int sum = 0;
                for(map.Entry<String, List<String>> val: map.entrySet()){
                    sum += val.getValue().size();
                }
                log(sum);
                map.wait(timeout);
        }