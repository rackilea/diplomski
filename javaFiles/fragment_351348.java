class App {
    DelegateClass delegate = new DelegateClass()

    def methodMissing( String name, args ) {
        if( name.startsWith( 'create' ) ) {
            delegate.create( args )
        }
        else if( name.startsWith( 'edit' ) ) {
            delegate.edit( args )
        }
    }
}