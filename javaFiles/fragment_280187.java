for(int i = 0; i < list.size(); i++){
  if (list.get(i).getId().equals(id)) {
    return i;
  }
}
return -1;