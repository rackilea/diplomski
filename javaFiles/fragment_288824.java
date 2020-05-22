Map<String, String> map = new HashMap<String, String>();
        for(Map.Entry<String, String> en: map.entrySet()){
            if(en.getValue()==null){
                System.out.println(en.getKey());
            }
        }