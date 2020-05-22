for(int i = 0; i<drum.size()-1; i++){

    //specifically on this line here:
    for(int j = 0; i<drum.size(); j++){
                 //^//That is not j

        if(drum.get(i).getPozitie() > drum.get(j).getPozitie()){
                                  //that means ^ will throw an IndexOutOfBoundsException
            Oras aux = drum.get(i);
            drum.add(i, drum.get(j));
            drum.add(j, aux);
        }
    }
}