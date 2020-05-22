private void printArtistFromMp3() {
    final String DIRECTORY = "C:\\Freek\\Dropbox\\Freek\\Muziek\\Queens of the Stone Age\\2000 - R\\";
    try {
        final MP3File mp3File = new MP3File(DIRECTORY + "01-Feel good hit of the summer.mp3");
        if (mp3File.hasID3v1Tag())
            System.out.println("Artist (ID3v1 tag): " + mp3File.getID3v1Tag().getArtist());
        if (mp3File.hasID3v2Tag())
            System.out.println("Lead artist (ID3v2 tag): " + mp3File.getID3v2Tag().getLeadArtist());
    } catch (IOException e) {
        e.printStackTrace();
    } catch (TagException e) {
        e.printStackTrace();
    }
}