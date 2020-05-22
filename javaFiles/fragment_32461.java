// Create an array to be filled with the bodies
// (better don't create a new one every time though)
Array<Body> bodies = new Array<Body>();
// Now fill the array with all bodies
world.getBodies(bodies);

for (Body b : bodies) {
    // Get the body's user data - in this example, our user 
    // data is an instance of the Entity class
    Animation anim = (Animation) b.getUserData();

    if (anim != null) {
        // Update the entities/sprites position and angle
        TextureRegion frame = anim.getKeyFrame( ... );
        // Now draw the frame using b.getPosition() and b.getAngle()
    }
}