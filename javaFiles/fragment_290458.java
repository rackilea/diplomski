for(int i = 0; i < 4; ++i){
        for(int j = i; j < 4; ++j){
            int t1 = al.get(i).get(j);
            al.get(i).set(j, al.get(j).get(i));
            al.get(j).set(i, t1);
        }
    }