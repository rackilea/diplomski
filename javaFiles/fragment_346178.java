public class Chromosome implements Comparable<Chromosome>{

ArrayList<Integer> gen; // xValues
private double fitness;

private static Random rand = new Random();

public ArrayList<Integer> getGen() {
    return new ArrayList<>(gen);
}

public double getFitness() {
    return fitness;
}

public Chromosome(ArrayList<String> gen) {
    this.gen = new ArrayList<>(gen);     
}

public Chromosome(int size) {
    this.gen = new ArrayList<>(size);     
    RandomizeGen(size);
}

public Chromosome(int size, int nil){
    this.gen = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
        gen.add(nil);
    }
}

public void RandomizeGen(int size) {
    for (int i = 1; i <= size; i++) {
        gen.add(i);
    }   
    Collections.shuffle(gen);
}

public void evaluate(double[][] prices) {
    fitness = AG.Fitness_Function.evaluateFunction(gen,prices);
}

public Chromosome Mutate(int genPos1, int genPos2){
    int temp;
    ArrayList<Integer> newGen = new ArrayList<>(gen);

    temp = newGen.get(genPos1);
    newGen.set(genPos1, gen.get(genPos2));
    newGen.set(genPos2, temp);
    return new Chromosome(newGen)

}

@Override
public int compareTo(Chromosome c) {
    int compareFitness = (int)((Chromosome) c).getFitness();
    return  compareFitness-(int)this.fitness;
}

}