enum Attributes {
    SPEED, SHOOTING;
};

private Map<Attributes,Integer> ratings = new LinkedHashMap<Attributes, Integer>();

int getRating(Attribute attribute) {
    return ratings.get(attribute);
}

int getSpeed() {
    return getAttribute(Attributes.SPEED);
}

int getOverall() {
    int total = 0;
    for (int i : ratings.values()) {
        total += i;
    }
    return total / Attributes.values().length;
}