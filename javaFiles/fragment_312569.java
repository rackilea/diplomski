ViewFactory<TextView> factory = new ViewFactory<TextView>() { 
    public TextView createView( Context c ) {
       return new TextView( c );
    }
}
new ViewPool<TextView>( factory );