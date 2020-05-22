// TEXTVIEW
if(tv.getParent() != null) {
    ((ViewGroup)tv.getParent()).removeView(tv); // <- fix
}
layout.addView(tv); //  <==========  ERROR IN THIS LINE DURING 2ND RUN
// EDITTEXT