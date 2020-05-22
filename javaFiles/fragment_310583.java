public class Level1 {

    private Asteroid populateAsteroid
    private Collision collision;

    public void init() {

        populateAsteroid = new Asteroid();
        // create and populate an arraylist with asteroid objects
        populateAsteroid.populateAsteroid(1);   
        collision = new Collision(populateAsteroid); //Pass in the reference to the asteroid.

}