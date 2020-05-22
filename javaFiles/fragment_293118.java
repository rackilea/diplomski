public CodeBlockWorker<T> Ignore<TClazz, TClasses>()
    where TCLazz : Exception
    where TClasses : Exception
 {
     var typename = typeof(TClazz).Name;
 }