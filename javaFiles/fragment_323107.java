public void reduce(K key, Iterator<V> values,
                          OutputCollector<K, V> output, 
                          Reporter reporter) throws IOException {
   // report progress
   if ((noValues%10) == 0) {
     reporter.progress();
   }

   // ...
}