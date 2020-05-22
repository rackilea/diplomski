if(!canMoveLeft) {
    if(!wantsToMoveRight) {
        velocity.x = 0;
    } else {
        velocity.x = 1;
    }
}

if(!canMoveRight) {
    if(!wantsToMoveLeft) {
        velocity.x = 0;
    } else {
        velocity.x = -1;
    }
}