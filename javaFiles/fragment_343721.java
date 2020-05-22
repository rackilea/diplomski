HashMap map = new HashMap<String, Integer>(){
        {
            put("Other", 3);
            put("Swimming", 2);
            put("D&D", 1);
        }
    };



    for (String hobby : selectedHobbiesList) {
        if(map.containsKey(hobby)){
            return map.get(hobby);
        }else{
            return 0;
        }
    }