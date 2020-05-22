public void move() {
    switch(direction) {
        case 'N': if (lastDirection != 'S') moveUp();
            break;
        ...
    }
    lastDirection = direction;
}