this.retryWhen({ errors ->
   val counter = AtomicInteger()
   .flatMap({ error ->
       if (counter.incrementAndGet() <= 2 && error is ApolloException) {
           return performTask
              .flatMap({ result ->
                   if (result) {
                       return Observable.just(true)
                   }
                   return Observable.error(error)
              })
       }
       return Observable.error(error)
   })  
})