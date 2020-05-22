private animalSounds getAnimal(String noise) {
    for(animalSounds a : animalSounds.values())
    {
        if(a.animalName.equals(noise))
        {
            return a;
        }
    }
    throw new IllegalArgumentException();
}