main() {
    checkPopulation();
}

checkPopulation() {
    ...
    particleDiffusion();
}

particleDiffusion() {
    ...
    if (stepsTaken < diffusionStep) {
        checkPopulation();
    }
}