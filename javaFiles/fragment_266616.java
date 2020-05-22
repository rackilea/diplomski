class Animal {
    // Class attributes

    class AnimalWithLegs extends Animal {
        public AnimalWithLegs(Animal base) { /* ... */ }

        @Override
        public boolean equals(Object o) { /* ... */ }
    }


    class AnimalWithType extends Animal {
        public AnimalWithLegs(Animal base) { /* ... */ }

        @Override
        public boolean equals(Object o) { /* ... */ }
    }


    class AnimalWithWeight extends Animal {
        public AnimalWithLegs(Animal base) { /* ... */ }

        @Override
        public boolean equals(Object o) { /* ... */ }
    }

    public Animal compareNumberOfLegs() {
        return new AnimalWithLegs(this);
    }

    public Animal compareType() {
        return new AnimalWithType(this);
    }

    public Animal compareWeight() {
        return new AnimalWithWeight(this);
    }

    @Override
    public boolean equals(Object o) { /* ... */ }
}