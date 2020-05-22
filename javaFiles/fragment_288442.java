public interface Collidable {
    boolean checkCollision(Collidable target);
    boolean visit(Collidable collidable);
    boolean accept(Circle circle);
    boolean accept(Line line);
}

public static class CollisionChecks {
    public static boolean check(Circle a, Circle b) { return false; }
    public static boolean check(Circle a, Line b) { return false; }
    public static boolean check(Line a, Line b) { return false; }
}

public class Line implements Collidable {
    @Override
    public boolean checkCollision(Collidable target) {
        return target.visit(this);
    }

    @Override
    public boolean visit(Collidable collidable) {
        return collidable.accept(this);
    }

    @Override
    public boolean accept(Circle circle) {
        return CollisionChecks.check(circle, this);
    }

    @Override
    public boolean accept(Line line) {
        return CollisionChecks.check(this, line);
    }

}

public class Circle implements Collidable {
    @Override
    public boolean checkCollision(Collidable target) {
        return target.visit(this);
    }

    @Override
    public boolean visit(Collidable collidable) {
        return collidable.accept(this);
    }

    @Override
    public boolean accept(Circle circle) {
        return CollisionChecks.check(this, circle);
    }

    @Override
    public boolean accept(Line line) {
        return CollisionChecks.check(this, line);
    }
}