public Completable downloadAndCache() {
   if (completable == null) {
          completable = Completable.fromAction(this::syncDownloadAndCache)
                                   .cache();
   }
   return completable;
}