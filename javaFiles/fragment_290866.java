public class ArchiveIndex {
      private IndexSearcher search;
      private AtomicInteger activeSearches = new AtomicInteger(0);
      private IndexWriter writer;
      private AtomicInteger activeWrites = new AtomicInteger(0);

      public List<Document> search( ... ) {
          synchronized( this ) {
              if( search != null && !search.getIndexReader().isCurrent() && activeSearches.get() == 0 ) {
                 searcher.close();
                 searcher = null;
              }

              if( search == null ) {
                  searcher = new IndexSearcher(...);
              }
          }

          activeSearches.increment();
          try {
              // do you searching
          } finally {
              activeSearches.decrement();
          }
          // do you searching
      }


      public void addDocuments( List<Document> docs ) {
          synchronized( this ) {
             if( writer == null ) {
                 writer = new IndexWriter(...);
             }
          }
          try {
              activeWrites.incrementAndGet();
              // do you writes here.
          } finally {
              synchronized( this ) {
                  int writers = activeWrites.decrementAndGet();
                  if( writers == 0 ) {
                      writer.close();
                      writer = null;
                  }
              }
          }
      }
  }