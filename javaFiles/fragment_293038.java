JSONArray shuffled = new JSONArray();   
    ArrayList<Integer> intArr1=new ArrayList<Integer>(jArray.length());
    for(int i = 0; i<jArray.length(); i++){
        intArr1.add(i);
    }
    Collections.shuffle(intArr1);
    for(int i = 0; i < intArr1.size(); i++){
        shuffled.put(i, jArray.get(intArr1.get(i)));
        if (i==(numQuestions-1))
                break;
    }
    return shuffled;