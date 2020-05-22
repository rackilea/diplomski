SongRespones songRespones = response.body();
                List<SongRespones.Songs> listSong = songRespones.getSongs();
                List<SongRespones.Songs> selectedSingersSongs = new Arraylist();
                for (SongRespones.Songs songs : listSong) {
                    if (songs.getSinger().getId() == getSingerId) {
                        Log.e(LOG, songs + "");
                        selectedSingersSongs.add(songs);
                    }
                }                    
                adapter.addMoreItem(selectedSingersSongs);