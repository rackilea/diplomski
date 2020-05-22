class DelegateClass {
    String create( args ) {
        "create ${args.join(',')}"
    }

    String edit( args ) {
        "edit ${args.join(',')}"
    }
}