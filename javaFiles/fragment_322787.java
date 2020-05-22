public int countGender(char gen) {

    int count = 0;

    if (this.gender == gen) {
        count++;
    }

    if (child1 != null) {
        count += child1.countGender(gen);
    }

    if (child2 != null) {
        count += child2.countGender(gen);
    }

    return count;
}