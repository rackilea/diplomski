List<type> list
public ContactArrayAdapter(Context context, int layoutResourceId, List<type> Contact, String bgColor,Typeface font) {
    super(context, layoutResourceId,Contact);
    this.list =Contact;
    this.bgColor = bgColor;
    myTypeFace = font;
    Log.v("CAA", " 1 = ");
}