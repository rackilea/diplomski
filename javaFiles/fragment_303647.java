if (input.isKeyDown(Input.KEY_K) && !energyPressed) {
    energy++;
    energyPressed = true;
}
if (!input.isKeyDown(Input.KEY_K)) {
    energyPressed = false;
}