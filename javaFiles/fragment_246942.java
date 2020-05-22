// Call this from OwnerController before returning data to page.
public void parsePets() {
  for (Pet pet : getPetsInternal()) {
    if ("cat".equals(pet.getType().getName())) {
      cats.add(pet);
    }
  }
}

public getCats() {
  return cats;
}