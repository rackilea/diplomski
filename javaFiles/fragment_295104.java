public Client(String name, Integer age, Integer amount) {
    this.name = name;

    if (age != null) {
        this.age = age;
    }

    if (amount != null) {
        this.amount = amount;
    }
}