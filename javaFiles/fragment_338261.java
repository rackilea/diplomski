@Override
public boolean onCreateOptionsMenu(Menu menu) {

    MenuInflater mnuInflater = getSupportMenuInflater();
    mnuInflater.inflate(R.menu.your_menu, menu); // your_menu IS THE MENU XML YOU HAVE CREATED
    return super.onCreateOptionsMenu(menu);
}