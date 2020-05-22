// init - note we keep our behaviors stateless so we only need one instance of each
public class Simulation () {
    BodyBehaviour planetBehavior = new PlanetBodyBehavior();
    BodyBehaviour starBehavior = new StarBodyBehavior()
    BodyBehaviour blackHoleBehavior = new BlackHoleBodyBehavior()
    // Just showing initialisation for a single star...
    Body body = new Body(initilising params....)
    body.setBehaviour (starBehavior);

        // iterations....
    while (!finished) {
        // assume we have many bodies and loop over them
        for (Body body : allBodies) {
            // update body positions etc.
            // check it's still a star - don't want to be changing it every iteration...
            if (body.hasBecomeBlackHole() {
                // and this is the point of it all....
                body.setBodyBehaviour(blackHoleBehavior);
            }
        }
    }
}