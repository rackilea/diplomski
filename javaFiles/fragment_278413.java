public Song(String aName, long aSize, String aArtist, String aAlbum){
    super(validateName(aName), aSize);
    setArtist(aArtist);
    setAlbum(aAlbum);
}

private static String validateName(String name) {
    if (whatever) {
        throw new Whatever();
    }
    return name;
}