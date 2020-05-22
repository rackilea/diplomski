List<Group> myActivePlaces = new ArrayList<Group>();
    List<Group> myPlaces = user.getMySites();
    for (Group group : myPlaces) {
        if(group.isActive()){
            myActivePlaces.add(group);
        }
    }