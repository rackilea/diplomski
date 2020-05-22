List<CD> cds = new ArrayList<>();

CD newCD = new CD();
int line = 0;

for(String string : this.ourDB) {
    if(line == ARTIST) {
        newCD.setArtist(string);
        System.out.println(string);
        line++;
    } else if(line == YEAR_AND_ALBUM_NAME){
        String[] elements = string.split(" ");

        String[] albumNameArr = Arrays.copyOfRange(elements, 1, elements.length);

        String year = elements[0];
        String albumName = join(albumNameArr, " ");

        newCD.setYear(year);
        newCD.setAlbumName(albumName);

        System.out.println(year);
        System.out.println(albumName);

        line++;
    } else if(line >= SONGS && !string.equals("")) {
        newCD.setSong(string);
        System.out.println(string);
        line++;
    } else if(string.isEmpty()){
        // We're starting a new CD!
        // Add the one we have so far to the list, and start afresh
        cds.add(newCD);
        newCD = new CD();
        line = 0;
    }
}

// Take care of the case the file doesn't end with a newline:
if (line != 0) {
    cds.add(newCD);
}