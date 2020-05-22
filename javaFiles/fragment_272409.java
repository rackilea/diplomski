public Bacteria binaryFission() {
    String speciesClone = this.species;
    ArrayList<Nucleotide> genomeClone = new ArrayList<Nucleotide>();
    //now iterate over the existing arraylist and clone each Nucleotide
    for(int index = 0; index < this.genome.size(); index++)
    {
        genomeClone.add(new Nucleotide(
                            genome.get(index).getBase(), //needs to be added to the Nucleotide class to retrieve the base variable
                            genome.get(index).getDegenerate() //needs to be added to be allowed to get its degenerate
                ));
    }

    return new Bacteria(speciesClone, genomeClone);
}