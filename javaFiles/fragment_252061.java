@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if(Utilities.onKeyDown(this, null, "Do you want to exit the application", keyCode, event)){
         return true;
    }
    return super.onKeyDown(keyCode, event);
}