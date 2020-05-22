if (c.isAnnotationPresent(Qualifier.class)) {
     Qualifier q = c.getAnnotation(Qualifier.class);
     if (q.theRight()) {
         bingo!
     }
}