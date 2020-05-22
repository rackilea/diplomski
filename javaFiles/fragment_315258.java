double[] chances = {1, 35, 0.85, 50, 0.1, 0.05, 0.01, 0.001, 65, 11};
    Random r = new Random();
    boolean dropped = false;
    for (int i = 0; i < chances.length; i++) {
        if (chances[i] > r.nextDouble() * 100) {
            System.out.println("Item with " + chances[i] + " chance is dropped");
            dropped = true;
            break;
        }
    }
    if (dropped == false) {
        System.out.println("Dropping default item");
    }