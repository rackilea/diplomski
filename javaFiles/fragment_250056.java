requestEntry.filter(v -> ...)
 .map(v -> ...)
 .publish(o -> {
     o.subscribe(...);
     return o;
 })
 .filter(v -> ...)
 .map(v -> ...)
 .subscribe(...)