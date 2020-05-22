@Override
public void onBackPressed() {
    Fragment frag = getSupportFragmentManager().findFragmentByTag("fragment");
    if(frag instanceOf SearchFragment && frag.getTag().equals("chat_fragment")) {
       floatingActionButton.setVisibility(View.INVISIBLE); // or visible
     } else {
        super.onBackPressed();
    }
}