private void setButtonRandomPosition(Button button){
    int randomX = new Random().nextInt(getDisplaySize(this).x);
    int randomY = new Random().nextInt(getDisplaySize(this).y);

    button.setX(randomX);
    button.setY(randomY);
}