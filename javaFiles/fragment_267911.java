private boolean add_student($first_name,$surname){

  text__firstname(ANY,NO_FLAGS).setText($first_name);
  text__surname(ANY,NO_FLAGS).setText($surname);
  return true;
}