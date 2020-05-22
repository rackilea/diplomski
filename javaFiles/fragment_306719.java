CustomView(Context c, Boolean animate) {
    super(c); //fisrt call
    this(c, animate, this); //second call
}
CustomView(Context c, Boolean animate, CustomView bind) {
    super(c); //third call

    //other actions

}