class Pizza {
    //...

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    @Override
    public String toString() {
        return String.format("cheese: %s", this.cheese);
    }
    //...
}