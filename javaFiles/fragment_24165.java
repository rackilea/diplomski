class CustomUseCase {
    .
    .
    .

    public static String getBestCombo() {
        .
        .
        .

        boolean[] bestCombo = Particle.bestGlobal();

        String bestComboString = "";
        for (Boolean b : bestCombo){
            bestComboString = bestComboString + b + " ";
        }

        return bestComboString;
    }
}