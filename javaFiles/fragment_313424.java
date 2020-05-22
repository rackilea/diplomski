List<Boat> boats = new ArrayList();
for (Vehicle object : input){
    if (object instanceof Boat){
        boats.add((Boat)object);
    }
}
return boats.toArray();