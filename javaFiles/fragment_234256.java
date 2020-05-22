public class Chromosome {
    private static final int CHROMOSOME_LENGTH = 10;

    /* Array of Gene object. */
    private Gene genes[];

    /* Default constructor. */
    public Chromosome() {
        // Simply allocates an array of 10 elements.
        genes = new Gene[CHROMOSOME_LENGTH];
    }

/*
     * Simple getter method.
     * Since m_Genes is private, you need a method like this
     * in order to access elements of the array.
     */
    public Gene getGene(int index) {
        return genes[index];
    }

/*
     * Simple setter method.
     * Since m_Genes is private, you need a method like this
     * in order to set the elements of the array.
     */
    public void setGene(int index, Gene gene) {
        genes[index] = gene;
    }

    /* The method which make the cross-over. */
    public Chromosome createChild(Chromosome parentA, Chromosome parentB) throws CloneNotSupportedException {
        Chromosome child = new Chromosome();

        // make the cross-over
        for (int i=0;i<10; i++)
        {   
            if (i<5)
            {
                // you need to call the clone() method
                child.genes[i] = (Gene)(parentA.genes[i].clone());
            }
            else
            {
                // you need to call the clone() method
                child.genes[i] = (Gene)(parentB.genes[i].clone());
            }
        }

        return child;
    }
}