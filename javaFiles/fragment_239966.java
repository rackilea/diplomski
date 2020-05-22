for(int i=0; i<myArray.size(); ++i) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", myArray.get(i).getName()); 
        map.put("gender", myArray.get(i).getGender()); 
        map.put("occupation", myArray.get(i).getOcupation()); 
        maps.add(map); // add this entry to the list
    );