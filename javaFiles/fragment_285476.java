//assuming sendEmail returns a Mono<Void>, takes care of offsetting any blocking send onto another Scheduler

source //we assume elements are also publishOn as relevant in `source`
   .flatMap(v -> {
       //if we can decide right away wether or not to send email, better do it here
       if (shouldSendEmailFor(v)) {
           //we want to immediately re-emit the value, then trigger email and wait for it to complete
           return Mono.just(v)
               .concatWith(
                   //since Mono<Void> never emits onNext, it is ok to cast it to V
                   //which makes it compatible with concat, keeping the whole thing a Flux<V>
                   sendEmail(v).cast(V.class)
               );
       } else {
           return Mono.just(v);
       }
    });