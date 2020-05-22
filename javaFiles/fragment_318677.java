@SuppressWarnings("unchecked")
public static <E> Set<E> getSetOfClass(Query q,Class<E> clazz) {
   return getSetOfClass(Query q,Class<E> clazz, true);
}

@SuppressWarnings("unchecked")
public static <E> Set<E> getSetOfClass(Query q,Class<E> clazz, boolean validate) {
    List result = q.getResultList();
    if (validate) {
       for (Object o:result) {
          if(!o.getClass().equals(clazz)) {
              // handle error
          }
       }
    }
    return new LinkedHashSet<E>( result );
}