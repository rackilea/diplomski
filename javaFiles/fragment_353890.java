public void newPlaylist(View view) {
    Playlist playlist = new Playlist("My First Playlist!"); // Create our playlist object
    // Since button is the only component that uses 'newPlaylist' as a click listener, the view will always be the button
    Button button = (Button) view; // We cast the view to button
    button.setText(playlist.getName()); // This edits the button text, might want to create a TextView for this
}