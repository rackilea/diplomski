class Pizza {

    public static enum Topping {
        HAM, MOZZARELLA, OLIVES, PINEAPPLE, SPINACH,
        CHEESE; // I added cheese. I love cheese.
    }

    public static enum Size {
        MEDIUM, LARGE;
    }

    private List<Topping> toppings = new ArrayList<>();

    public void addTopping(Topping topping) {
        // First, test if the list with toppings does not contain
        // the given topping more than once.
        this.toppings.add(topping);
    }
}