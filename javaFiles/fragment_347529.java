Collections.sort(animals, new Comparator<Animal>() {

    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.getName().compareTo(a2.getName()); // or different code comparing the Animals
    }

});