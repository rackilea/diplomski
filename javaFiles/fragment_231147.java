void mainLoop() {
    // make lots of generations
    for (int generation = 0; generation < MAX_GEN; generation++) {
        float mutationBoundary = getMutationBoundary(generation);   
        float creationBoundary = getCreationBoundary(mutationBoundary);
        createNewGeneration(mutationBoundary, creationBoundary);
        // Do some stuff with this generation, e.g. measure fitness
    }
}

void createNewGeneration(float mutationBoundary, float creationBoundary) {
    // create each member of this generation
    for (int i = 0; i < MAX_POP; i++) {
        createNewMember(mutationBoundary, creationBoundary);
    }
}

void createNewMember(float mutationBoundary, float creationBoundary) {
    float random = 10 * generator.nextFloat();

    if (random > mutationBoundary) {
        mutate();
    }
    else {
        if (random < creationBoundary) {
            randomlyCreate();
        }
        else {
            crossover();
        }
    }
}

float getMutationBoundary(int generation) {
    // Mutation bin is is initially between [8, 10].
    // Lower bound slides down linearly, so it becomes [7.9, 10], [7.8, 10], etc.
    // Subtracting 0.1 each generation makes the bin grow in size.
    // Initially the bin is 10 - 8 = 2.0 units wide, then 10 - 7.9 = 2.1 units wide,
    // and so on. So the probability of mutation grows from 2 / 10 = 20%
    // to 2.1 / 10 = 21% and so on.
    float boundary = 8 - 0.1f * generation;

    if (boundary < 0) {
        boundary = 0;
    }
    return boundary;    
}

float getCreationBoundary(float creationBoundary) {
    return creationBoundary / 8; // fixed ratio
}