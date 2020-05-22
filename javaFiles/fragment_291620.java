// Retrieve the set of artists for this user
// Substitute String for Artist here if you're just storing the names
Set<Artist> artists = artistsFromUser.get(user);
if (artists == null) {
    // If the set was not created for this user yet
    // you need to create it and store it in the map
    artists = new HashSet<>();
    artistsFromUser.put(user, artists);
}
// Add the new artist to the set
artists.add(artist);