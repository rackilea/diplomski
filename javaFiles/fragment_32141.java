@Override
protected void onStop() {   
super.onStop(); 
session.setLoggedin(false);
session.logout();
}