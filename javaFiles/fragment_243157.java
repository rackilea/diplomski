private void crashed() {
    planeAnimation = explosionAnimation;
    explosionTime = TimeUtils.nanoTime();
    gameover = true;

    System.out.println("timer started");
}