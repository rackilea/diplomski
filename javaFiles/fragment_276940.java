// Member variable of this class
List<User> userList = new ArrayList<>();

@Override
public void onResponse(JSONObject response) {
    for (int i = 0; i < 100; i++) {
        // Add elements to your arraylist
        userList.add(user);
    }

    /* That's it, your arraylist is updated. Now call whatever method that
     was supposed to retrieve the result (the arraylist) of this callback */
}