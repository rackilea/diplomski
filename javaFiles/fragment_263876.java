class SearchableRepositoryImpl<T> implements SearchableRepository<T> {
      private Class<T> klass;
      public SearchableRepositoryImpl(Class<T> klazz){
        this.klass = klazz;
      }

      public Page<T> search(String query, Pageable page) {
            // Right here, I need the Class<T> of T so that I can create
            // the JPA query
        }
    }

    class NewsRepositoryImpl<Article> implements NewsRepository<Article> 
    {
      private SearchableRepository<Article> searchRepo = new SearchableRepositoryImpl(Article.class);
      public Page<T> search(String query, Pageable page){
        // delegate
        return searchRepo.search(query, page);
      }
}