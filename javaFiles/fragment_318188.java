for (int i = 0; i < array.size(); i++){
    if (array.get(i).getName().equalsIgnoreCase(a)) {
        System.out.println(i);
        return i;
    }   
    else return 0;
}