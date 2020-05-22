public static void main(String[] args) {
    double startFrequency = Math.round(88 * 100);
    double maxFrequency = Math.round(108 * 100);
    for (double f = startFrequency; f < maxFrequency; f += 5) {
        boolean nextFavFound = false;
        for (double f2 : favFrequencies) {
            if (f / 100 == f2) {
                nextFavFound = true;
                break;
            }
        }
        if (nextFavFound) {
            System.out.println("next favFrequency: " + f / 100);
        }
    }
}