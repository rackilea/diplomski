for(int i = 0; i<drum.size()-1; i++){
    for(int j = 0; j<drum.size(); j++){
                 //^ j
        if(drum.get(i).getPozitie() > drum.get(j).getPozitie()){
            Oras aux = drum.get(i);
            drum.add(i, drum.get(j));
            drum.add(j, aux);
        }
    }
}