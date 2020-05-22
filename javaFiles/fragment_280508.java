public void tick() {
    if(acceptedKeyPressed) {
        numTicksHeld++;
        if(numTicksHeld > KEY_HELD_THRESHOLD)
            movement.setRate(4)
    } else {
        numTicksHeld = 0;
        movement.setRate(1)
    }
}