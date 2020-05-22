.makeComputingMap(
       new Function<Long, CustomObject>() {
         public CustomObject apply(Long id) {
           return getObjectFromPersistence(id);
         }
       });