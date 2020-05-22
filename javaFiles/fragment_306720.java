CustomView(Context c, Boolean animate) {
    this(c, animate, null);
}
CustomView(Context c, Boolean animate, CustomView bind) {
    super(c); //third call
     if(bind==null) {bind=this}
    //do whatever you like with your "bindings"
}