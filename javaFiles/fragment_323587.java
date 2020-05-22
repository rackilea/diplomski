package com.test;

public class Vector {

    private int x;
    private int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
    // if you don't want to create new vector and subtract from it self, then return type of this method would be void only.
    public Vector subtract(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y);
    }

    @Override
    public String toString() {
        return this.x + " : "+ this.y;
    }

    public static void main(String[] args) {
        Vector vector1 = new Vector(10, 10);
        Vector vector2 = new Vector(5, 5);
        Vector vector3 = vector1.subtract(vector2); 
        System.out.println(vector3);
    }
}