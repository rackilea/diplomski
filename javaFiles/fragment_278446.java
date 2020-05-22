for (float x = 1F; x < 4_000_000F; x += 0.25F) {
        result += 1F / (float) Math.sqrt(x);
    }
    midTime = System.nanoTime();
    for (float x = 1F; x < 4_000_000F; x += 0.25F) {
        result -= fastInverseSquareRoot(x);
    }
    endTime = System.nanoTime();
    if (result == 0) System.out.println("Wow!");