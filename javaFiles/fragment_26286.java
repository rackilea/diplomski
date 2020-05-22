package gen;

import java.util.HashMap;
import java.util.Map;

class Flower {

    Map<String, Chromosome> genes;

    Flower() {
        genes = new HashMap<>();
        genes.put("color", new Chromosome(new Genotype(64, 1.0f), new
                Genotype(25, 0.5f)));
        Genotype test = genes.get("color")
                .getDomGene(); //should return the first param passed to the new chromosome
    }

    public static void main(String[] args) {
        new Flower();
    }
}