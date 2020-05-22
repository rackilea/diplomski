ResultSet rs = stmt.executeQuery("SELECT PATH, WORD FROM TABLE_A");

while(rs.next()) {
    if (map.containsKey(rs.getString("WORD"))) { // If the word is already in your hash map
        TreeSet<String> path = map.get(rs.getString("WORD")); //get the set of files where this word exist 
        path.add(rs.getString("PATH")); // add the new path to the set
        map.put(rs.getString("WORD"), path); // update the map
    } else { // else if the word is new
        TreeSet<String> path = new TreeSet<String>(); // create a new set
        path.add(rs.getString("PATH")); // add the path to the set
        map.put(rs.getString("WORD"), path); // add the new data to the map
    }
}