class Rect {

    double x, y, width, height;

    ... members and stuff

    Rect intersection(Rect rect2) {
        double newX = Math.max(this.x, rect2.x);
        double newY = Math.max(this.y, rect2.y);

        double newWidth = Math.min(this.x + this.width, rect2.x + rect2.width) - newX;
        double newHeight = Math.min(this.y + this.height, rect2.y + rect2.height) - newY;

        if (newWidth <= 0d || newHeight <= 0d) return null;

        return new Rect(newX, newY, newWidth, newHeight);
    }

    double area() {
        return this.width * this.height;
    }

}