Map<String,String> map = new HashMap<>();
    if(map.containsKey(myKey) && StringUtils.isNotBlank(map.get(myKey)) 
                             && map.containsKey(map.get(myKey))) {
        flag=false;
    } else {
        flag=true
    }