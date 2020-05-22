/**
 * Save a new Album.
 */
public Album save(Album album) {
    getJpaTemplate().persist(album);
    return album;
}

/**
 * Update an existing Album.
 */
public Album update(Album album) {
    return getJpaTemplate().merge(album);
}