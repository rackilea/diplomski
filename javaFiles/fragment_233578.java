while (iterator.hasNext()) {
            JSONObject factObj = (JSONObject) iterator.next();
            for (Object key : factObj.keySet()) {
                System.out.println(key+":"+factObj.get(key));
            }
        }