void start() {
    // Either get p
    context1.get(..).to( new Receiver<P> { onSuccess(P resp){p = resp;} ... }).fire();
    // OR create p
    p = context2.create( P.class );
    // Then save p
    req = context2.persist(p).to( new Receiver<P>{  /* note do not use context1 */
        onViolation(...) { /*JSR 303 handler*/ };
        onFailure( error ) { /* handle */ error.getMessage() }; 
        onSuccess(X x) { /* whatever persist() returns handler */ }; } ); 
    // drive editor with p
    driver.edit( p, req);    
}

....
void onSave() {    
    // editor
    ctxt = driver.flush()  /* note ctxt == context2 */
    if ( driver.hasErrors() ) { /*JSR 303 handler*/};
    // RF
    ctxt.fire();
}