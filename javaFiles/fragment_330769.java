for (int i=0; i<cityList.size();i++){
    if (cityList.get(i).getName().toLowerCase().compareTo(city.getName().toLowerCase()) == 0){
        //city is the same as one of the cities in the list (case insensitive)
        //quit the loop (does not store two cities with same name)
        return;
    }else if (cityList.get(i).getName().toLowerCase().compareTo(city.getName().toLowerCase()) <0 && cityList.get(i+1).getName().toLowerCase().compareTo(city.getName().toLowerCase()) >0){
            //city before is lexicographically lesser but city after is lexicographically more (case insensitive)
            cityList.add(i+1, city);
            //inserts at i+1, which is after the lexicographically smaller city, but is before the city which is lexicographically larger
            return;
    }

}
cityList.add(city);