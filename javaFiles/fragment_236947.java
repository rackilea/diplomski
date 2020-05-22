@Override
public void afterTextChanged(Editable s) {
    String txt = searchusersedittext.getText().toString();
    // or String txt = s.toString();
    if( !txt.isEmpty() ) {
        recyclerViews.setVisibility(View.VISIBLE);
        filter(txt);
    }
    else {
        recyclerViews.setVisibility(View.INVISIBLE);
    }
}