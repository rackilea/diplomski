public class GenericRowBuilder<R> implements RowBuilder<R> {
      public GenericRowBuilder(Class<R> clazz, TokenParser<?>[] parsers) {
          // Extract the return types of the reified parse objects' `parse` 
          // methods, and use this to locate a matching `Constructor<R>` in 
          // `clazz`.  If there isn't one, throw an exception.
          this.clazz = clazz;
          this.parsers = parsers;
      }
      public R parse(List<String> tokens) {
          // Check number of tokens matches number of parsers.
          // Parse each token with corresponding parsers.
          // Use the `Constructor<R>` found above to create the instance of `R`
      }
  }