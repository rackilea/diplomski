public void addAnimal(Animal a) {
    if (i < 10) {
        if (animals[i] != null) {
            i++;
            addAnimal(a);
        } else {
            animals[i] = a;
            a.setCurrentRoom(this); // Setting room of animal
        }
    } else {
        System.out.println("Room full");
    }
}