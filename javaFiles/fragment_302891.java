List<Song> songs = service.getSongs();

List<ArtistWithSongs> artistWithSongsList = songs.stream()
               .collect(Collectors
               .groupingBy(s -> s.getArtist(), Collectors.toList()))
               .entrySet()
               .flatMap(as -> new ArtistWithSongs(as.getKey(), as.getValue()))
               .collect(Collectors.toList());