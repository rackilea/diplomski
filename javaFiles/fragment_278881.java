enum Pet {
    DOG(R.string.dog), CAT(R.string.cat);

    int nameResourceId;
    Pet(int nameResourceId) {
        this.nameResourceId = nameResourceId;
    }
}

...

list[i] = getString(pet.nameResourceId);