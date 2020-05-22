if(-minSpread < xSpeed && xSpeed < minSpeed) {
    xSpeed = 0;
    if(-minSpread < ySpeed && ySpeed < minSpeed) {
        ySpeed = 0;
        return -1;
    }
} else if(-minSpread < ySpeed && ySpeed < minSpeed) {
    ySpeed = 0;
}