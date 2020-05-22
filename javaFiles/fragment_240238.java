class PersonAverager {
    double sum = 0;
    int count = 0;

    void accept(Person p) {
        sum += p.getAge();
        count++;
    }

    PersonAverager combine(PersonAverager other) {
        sum += other.sum;
        count += other.count;
        return this;
    }

    double average() {
        return count == 0 ? 0 : sum / count;
    }
}