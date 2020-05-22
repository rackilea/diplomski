public void update() {
    x += xSpeed;
    y += ySpeed;

    if (x >= gameView.getWidth() - bmp_width){
        xSpeed = -xSpeed;
        x = gameView.getWidth() - bmp_width;
    }else if(x <= 0){
        xSpeed = -xSpeed;
        x = 0;
    }
    if (y >= gameView.getHeight() - bmp_height){
        ySpeed = -ySpeed;
        y = gameView.getHeight() - bmp_height;
    }else if(y <= 0){
        ySpeed = -ySpeed;
        y = 0;
    }
}