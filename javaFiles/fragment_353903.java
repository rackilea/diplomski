public enum CommonPet implements Pet {
    CAT("Meow!"),
    DOG("Woof! Woof!");

    private final String cry;

    CommonPet(String cry) {
        this.cry = cry;
    }

    @Override
    public String talk() {
        return cry;
    }
}