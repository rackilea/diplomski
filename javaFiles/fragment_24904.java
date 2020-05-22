@Override
public void onResume() {
    long now = new Date().getTime();
    if (now - lastActivity > xxxx) {
       // startActivity and force logon
    }
}