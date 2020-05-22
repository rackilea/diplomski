int x_posI = (int) x_pos;
int y_posI = (int) y_pos;

if (downPressed && leftPressed) {
    this.sprite = hero225;
} else if (downPressed && rightPressed) {
    this.sprite = hero135;
} else if (upPressed && rightPressed) {
    this.sprite = hero45;
} else if (upPressed && leftPressed) {
    this.sprite = hero315;
} else if (leftPressed == true) {
    this.sprite = hero270;
} else if (rightPressed == true) {
    this.sprite = hero90;
} else if (upPressed == true) {
    this.sprite = hero;
} else if (downPressed == true) {
    this.sprite = hero180;
}

// this.sprite will contain value set on last "movement"
g.drawImage(this.sprite, x_posI, y_posI, this);