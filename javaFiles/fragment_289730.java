public void listAll()  {
    if(songs.isEmpty()) {
        System.out.println("There are no songs on the playlist");
    } else {
        for (Song a : songs) {
            System.out.println(a);
        }
    }
}