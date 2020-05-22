public int getBackground(){
    Random generate = new Random();
    int randomNumber = generate.nextInt(mBackground.length);
    int background = mBackground[randomNumber];
    return background;
}