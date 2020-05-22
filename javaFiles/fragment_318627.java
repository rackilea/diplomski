/**
 * List the authors. Sort them by name so it will look good.
 */
public List<Author> listAuthors(){
    List<Author> authors = readAuthorsFromFileOrSomething();
    Collections.sort(authors);
    return authors;
}

/**
 * List unique authors. Sort them by name so it will look good.
 */
public SortedSet<Author> listUniqueAuthors(){
    List<Author> authors = readAuthorsFromFileOrSomething();
    return new TreeSet<Author>(authors);
}