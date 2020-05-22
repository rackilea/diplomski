if(reader != null){
        while ((line = reader.readLine()) != null) {
            if ((line.length()>0)&&(line.charAt(0) != '#')){
                String[] tokens = line.split("\\s+", 2);
                lists.put(tokens[0], tokens[1]);
            }
        }

        Iterator iterator = lists.keySet().iterator();  

        while (iterator.hasNext()) {  
           String key = iterator.next().toString();  
           String value = lists.get(key).toString();  

           System.out.println("KEY: " +key + " VALUE:" + value);  
        }
    }