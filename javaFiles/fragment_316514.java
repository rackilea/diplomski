private void logoutUser() {
  session.setLogin(false);    
  db.deleteUsers();
  Intent intent = new Intent(getActivity(), LoginActivity.class);     
  startActivity(intent);
  getActivity().finish();  
}