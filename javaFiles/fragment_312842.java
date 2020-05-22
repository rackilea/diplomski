public String getColor() {
    System.out.println("-------------------------get " + Thread.currentThread().getName() + this.color + " " + System.nanoTime());
    return color;
}

public void setColor(String color) {
    System.out.println("-------------------------set " + Thread.currentThread().getName() + color + this.color + " " + System.nanoTime());
    this.color = color;
}