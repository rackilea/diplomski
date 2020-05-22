public game_loop() {
    update_timer(); // Update the timer because everything else past this point will depend on the time this game loop started running
    physics_update(); // Run calculations and setup events
    update(); // Here would loop through each object
    fixed_update(); // Would loop through each object again, but provide a more concise time frame based on screen updates, frame rate and physics
}