private List<User> findUsers (List <User> users, String park){
    List<User> tempList = new ArrayList<User>();
    List<Address> addresses = new ArrayList<Address>();
    for (User user : users) {
        addresses = user.getAddresses();
        for (Address address : addresses) {
            if (address.getName().equals(park))
                tempList.add(user);
        }
    }
    return tempList;
}