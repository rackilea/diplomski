private void run() {
    switch (userInput) {
    case 1: 
        songDatabase.addNewSong();
        break;
    case 2:
        songDatabase.removeSong();
        break;
    case 3:
        songDatabase.sortSongs();
        break;
    default:
        System.out.println("Please enter a valid number.");
        break;
    }
}