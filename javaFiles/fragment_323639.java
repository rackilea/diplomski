ArrayList<String> newLisM = new ArrayList<>();

for (int i = 0; i <booleanList.size(); i++) {
        if(booleanList.get(i))
            for (int j = 0; j < 3; j++) {
                newLisM.add(lisM.get(i+j));
            }
    }