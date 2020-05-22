Iterable<Iterable<String>> slices = 
   Iterables.limit(
       Iterables.partition(
           Iterables.skip(
               Iterables‌​.cycle(originalSet),
               i),
           n),
       m);