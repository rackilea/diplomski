Playlist p = new Playlist();
p.setTitle("Test Playlist");
Song s = new Song(1, "Test Song1", "Me", 2014, 1, 11111);
Song s2 = new Song(2, "Test Song2", "Me", 2014, 1, 11111);
Song s3 = new Song(3, "Test Song3", "Me", 2014, 1, 11111);
p.addSong(s);
p.addSong(s2);
p.addSong(s3);
savePlaylist(p);

Playlist p2 = getPlaylist(1);
Log.i("Playlist:", ""+p2.getSize());