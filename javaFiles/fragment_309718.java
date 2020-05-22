public int compareTo(Person other) {
    int result = Integer.compare(this.getPriority(), other.getPriority());
    if (result == 0) {
        result = this.getRegistrationDate().compareTo(other.getRegistrationDate())
    }
    return result;
}