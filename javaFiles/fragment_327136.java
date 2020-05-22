for( Helper h : get( current ) ) {
    h.copy( obj, result );
}

public Helper[] get( Class<?> type ) {
    ... look in cache. If nothing there, create helper using  PropertyDescriptors.
}