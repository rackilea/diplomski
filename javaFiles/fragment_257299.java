public void handleVelocity() {
    float minMoveSpeed = 1;
    if (this.moveSpeed < minMoveSpeed && this.moveSpeed > -minMoveSpeed) {
        this.moveSpeed = 0;
    } else {
        float dampening = 0.00002f;
        double sign = -(int) Math.signum(moveSpeed);
        this.moveSpeed += (float) (dampening * sign);
    }
    xPos += this.moveSpeed;
}