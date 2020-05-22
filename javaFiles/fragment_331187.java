for(int i = 0; i < b.size(); i++) {
    for(int j = 0; j < b.size(); j++){
        for(int k = j+1; k < b.size(); k++) {
           if(j != i && k != i)
               System.out.println(b.get(j) + "*" + b.get(k));
        }
    }
}