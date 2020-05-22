for (int i = 0; i < frameAnimation.getWidth() + 1; i++) {
    if (i == frameAnimation.getWidth()) {
        //Level--;
        i = 0;
    }
    frameAnimation.add(new AnimationPane(i));
    try {
        Thread.sleep(Level);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    frameAnimation.revalidate();
}