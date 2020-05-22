class Tisha {

    // An integer field to store the current level of refinement.
    int level = 0;

    // An array of probabilities for each level of refinement.
    double[] probs = new double[]{
        0.535, 0.335, 0.335, 0.335, 0.335,
        0.335, 0.335, 0.335, 0.285, 0.235,
        0.155, 0.085
    };

    // The random number generator
    Random random = new Random();

    // This function tries to perform a refinement
    public void tryRefinement() {
        if (random.nextDouble() <= probs[level]) {
            level++;
            System.out.println("Refine successful  -  Refine level " + level);
        } else {
            level--;
            if (level >= 0)
                System.out.println("Refine failed  -  Refine level " + level);
            else
                System.out.println("Refine failed  -  Refine reset");
        }
    }

    // The main method
    public static void main(String[] args) throws InterruptedException {

        // Create a 'Tisha' object (are you familiar with OOP?)
        Tisha tisha = new Tisha();

        // Keep refininig until the level reaches 0
        do {
            tisha.tryRefinement();
            Thread.sleep(250);
        } while (tisha.level > 0);
    }
}