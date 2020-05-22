class Star{
    Integer number;
    StarImage image;
    Star(StarImage image, Integer number){
        this.number = number;
        this.image = image;
}
// then later...
boolean collided(Star star, Integer expectedAnswer){
    return star.number.equals(expectedAnswer);
}