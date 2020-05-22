if (emailExistsInList(data.email))
  updateExistingCeleb(data);
else
  addNewCeleb(data);

...

boolean emailExistsInList(String email){
  for (Celebrity celeb: celebs)
    if (celeb.email.equals(email)) return true;
  }
}

void updateExistingCeleb(String email, CelebData data){
  // your search and update code here 
}

void addNewCeleb(CelebData data){
  Celeb newCeleb = // your instantiation logic here
  celebs.add(newCeleb);
}