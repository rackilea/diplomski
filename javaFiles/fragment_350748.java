private static HashMap<Integer, String> currentFollowers = 
                                        new HashMap<Integer, String>();

public static void main(String[] args) {
    // get the string from the web
    String jsonInputString = "";
    JSONObject json = new JSONObject(jsonInputString);

    // check total followers (this is what you should know)
    Integer totalFollowers = json.getInt("_total");
    System.out.println("Total followers: " + totalFollowers);

    // check if there are new followers (exercise: what about unsubscribers?)
    if(totalFollowers > currentFollowers.size()) {
        // get the array of followers
        JSONArray followerArray = json.getJSONArray("follows");

        // go through it and check if the user is in the HashMap
        for(int i = 0; i < followerArray.length(); ++i) {
            JSONObject follower = new JSONObject(
                                        followerArray.get(i).toString()
                                  );
            JSONObject userObject = follower.getJSONObject("user");
            Integer id = userObject.getInt("_id");

            if(!currentFollowers.containsKey(id)) {
                // here you have not to print but to sendit to IRC
                String name = userObject.getString("display_name");
                System.out.println("New subscriber: " + name + ", welcome!");
                currentFollowers.put(id, name);
            }
        }
    }
}