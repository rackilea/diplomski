interface Positioned {
    int getX();
    int getY();
    default int distanceTo(Positioned pos) {
        int dx = pos.getX() - getX();
        int dy = pos.getY() - getY();
        return (int) Math.sqrt(dx*dx + dy*dy);
    }
}

interface Edible extends Positioned {
    int getNutritionalValue();
}

interface Agent extends Positioned {
    Edible wat2Eat();

    default Edible closestFood(List<Edible> food) {
       // code to find closest edible food in given list
    }
}

abstract class AbstractFood implements Edible, Positioned {
    int locX, locY;
    int getX() { return locX; }
    // ... etc ...
}

class Water extends AbstractFood {
    // ...
}

class Dinosaur extends AbstractFood, implements Agent {
    Edible wat2Eat() {
        if ( hungry ) {
           if (isHerbivore())
              return closestFood(grasses);
           else
              return closestFood(dinosaurs);
        else
           return closestFood(waters);
    // ...
}