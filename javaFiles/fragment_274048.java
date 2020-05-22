changePetNames(Person person, Pets[] pets, String[] names) {
    synchronized(person) {
        // make updates
    }
}

neuter(Pets[] pets) {
    for (Pets pet: pets) {
        // make sure pets owner exists
        synchronized(pet.getOwner()) {
            // make updates
        }
    }
}