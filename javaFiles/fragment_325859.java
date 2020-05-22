synchronized(breeders) {
    for (Breeder b : breeders) {
       for (Strain s : b.getStrains()) {
            strains.add(s);
        }
    }
}