private void move(Status direction) {
switch (direction) {
case LEFT:
    this.clearActions();
    this.addAction(Actions.sequence(
            Actions.moveTo((getX() - Config.BLOCK_SIZE), getY(), speed),
            new RunnableAction() { //to know when hes done to get the next move
                public void run() {
                    moveDone = true;
                }
            }));
    break;
case RIGHT:
    this.clearActions();
    this.addAction(Actions.sequence(
            Actions.moveTo((getX() + Config.BLOCK_SIZE), getY(), speed),
            new RunnableAction() {
                public void run() {
                    moveDone = true;
                }
            }));
     break;
case DOWN:
    this.clearActions();
    this.addAction(Actions.sequence(
            Actions.moveTo(getX(), (getY() - Config.BLOCK_SIZE), speed),
            new RunnableAction() {
                public void run() {
                    moveDone = true;
                }
            }));
     break;
case UP:
    this.clearActions();
    this.addAction(Actions.sequence(
            Actions.moveTo(getX(), (getY() + Config.BLOCK_SIZE), speed),
            new RunnableAction() {
                public void run() {
                    moveDone = true;
                }
            }));
     break;
default:
    break;
}