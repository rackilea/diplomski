if (TimeUtils.nanoTime() - lastDropTime > 1000000000){
    switch (MathUtils.randomInt(4)){
        case 0: spawnBalls1(); break;
        case 1: spawnBalls2(); break;
        case 2: spawnBalls3(); break;
        case 3: spawnBalls4(); break;
    }
}