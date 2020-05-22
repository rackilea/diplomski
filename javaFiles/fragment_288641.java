A a = map.get(newA.getS());
if (a == null) {
    map.put(newA.getS(), newA); //new string => new item in the map
} else {
    a.setD(a.getD() + newA.getD()); //found string => updating the existing item
}