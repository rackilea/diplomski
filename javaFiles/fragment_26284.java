package gen;

class Chromosome {

    Genotype geneOne;
    Genotype geneTwo;

    Chromosome() {
        System.out.println("Chromosome.Chromosome");
    }

    Chromosome(Genotype gOne, Genotype gTwo) {
        System.out.println("Chromosome.Chromosome");
    }

    void setGeneOne(Genotype gene) {
        System.out.println("Chromosome.setGeneOne");
    }

    void setGeneTwo(Genotype gene) {
        System.out.println("Chromosome.setGeneTwo");
    }

    Genotype getDomGene() {
        System.out.println("return genOne");
        return geneOne;
    }

    Genotype getRecGene() {
        System.out.println("return genTwo");
        return geneTwo;
    }
}