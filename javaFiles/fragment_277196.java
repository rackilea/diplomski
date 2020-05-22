public List<String> aktualisiereListe(List<Control> list ){
    ...
    for(int i=0; i<=list.size()-1; i++){
        if(i%3 == 1){
            ComboBox cB = (ComboBox) list.get(i);
            ...
        }

        if(i%3 == 2 || i%3 == 0){
            TextField tF = (TextField) list.get(i);
            ...
        }
    }
    ...
}