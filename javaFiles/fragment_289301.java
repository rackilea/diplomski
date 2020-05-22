class Marriage {
    String person1;
    String person2;

    Marriage(String p1, String p2) {
        person1 = p1;
        person2 = p2;
    }

    @Override
    public String toString() {
        return person1 + " " + person2;
    }
}