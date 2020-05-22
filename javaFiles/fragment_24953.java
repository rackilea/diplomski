public interface Album {
    /**
     * This method returns the media type of the album. 
     * @return the media type of the album, either CD or DVD
     * @see #getTitle()
     * @see #getGenre()
     */
     String getMediaType();

    /**
     * This method returns the title of the album. 
     * @return the title of the album
     * @see #getMediaType()
     * @see #getGenre()
     */
     String getTitle();

    /**
     * This method returns the genre of the album. 
     * @return the genre of the album
     * @see #getTitle()
     * @see #getMediaType()
     */
    String getGenre();

}