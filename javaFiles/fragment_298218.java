enum Gender {
    MALE (28),
    FEMALE (28);

    int age;

    Gender(int genderAge) {
        this.age = genderAge;
    }

    public int getAge() {
        return age;
    }
}