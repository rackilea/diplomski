public static boolean delete(final File directory){
    assert directory != null && directory.exists();
    if(!directory.isDirectory())
        return directory.delete();
    for(final File f : directory.listFiles())
        delete(f);
    return directory.delete();
}